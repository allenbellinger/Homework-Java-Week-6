package com.promineotech;

public class App {
    // I added these parameters at the class level to be used through multiple methods in the App class
    public static boolean playNewGame = true;
    public static Deck theDeck;
    public static Player player1;
    public static Player player2;

    public static void main(String[] args) {
        //Loop to allow for multiple games to be played.
        //I made a more interactive version of the game than what is described in the assignment. I wanted it to feel
        //like you were playing the game against a computer opponent and that you were doing the actions that needed
        //to happen.
        while (playNewGame) {
            //I pulled out as much as I could in methods, and I made a new class called Output for all
            //Console inputs and outputs
            Output.introduction();
            player1 = Output.createPlayer();
            player2 = new Player("Computer");
            theDeck = new Deck();

            theDeck.shuffle();
            dealCards();

            Output.flipFirstCard();
            //This is a check to see if the hands of each player is empty yet, which is when the game is over.
            //I actually only check to see if player1's hand is empty, because they should both be empty at the exact
            //same time.
            while(handsAreNotEmpty())
                playRound();

            playNewGame = Output.finishGame(player1, player2);
        }
    }
    //Methods were extracted from the main method with what I hope are clear names to make it so each method does only
    //one thing. I did it to clean up my code and add as much clarity to what is happening as I could.
    private static void playRound() {
        Card card1 = player1.flip();
        Card card2 = player2.flip();
        Output.cards(card1, card2);
        int card1Value = card1.getValue();
        int card2Value = card2.getValue();
        //I needed both the value of each card and eventually the name of that card to use in the output. That is why
        //there are 2 places that each card is assigned to a variable.

        if (card1Value > card2Value)
            getsPoint(player1);
        else if (card2Value > card1Value)
            getsPoint(player2);
        else
            //I made a new section for a tiebreaker. I used what I've played in the past with drawing 3 extra, face down
            //cards and then a last one to break the tie. If that is a tie, you do it again until there isn't a tie
            //anymore.
            tiebreaker();
        if (handsAreNotEmpty())
            Output.flipAnotherCard();
    }
    private static void tiebreaker() {
        //The increments in this method are for points added due to the tiebreaker that I've made. When you flip 3 cards,
        //you add 3 cards to the potential points to win from the tiebreaker.
        int increment = 1;
        boolean thereIsStillATie = true;

        while(thereIsStillATie) {
            increment += 4;
            Output.flipFourCardsForTiebreak();
            flipThreeCards(player1);
            flipThreeCards(player2);
            Card card1 = player1.flip();
            Card card2 = player2.flip();
            Output.cards(card1, card2);
            thereIsStillATie = resolvesTiebreakOrReturnsTrue(card1.getValue(), card2.getValue(), increment);
        }
    }
    public static boolean resolvesTiebreakOrReturnsTrue(int value1, int value2, int increment) {
        if (value1 > value2) {
            winsTiebreak(player1, increment);
            return false;
        }
        else if (value2 > value1) {
            winsTiebreak(player2, increment);
            return false;
        }
        return true;
    }
    public static void getsPoint(Player player) {
        player.incrementScore();
        Output.getsOnePoint(player);
    }
    public static void winsTiebreak(Player player, int increment) {
        for(int i = 0; i < increment; i++)
            player.incrementScore();
        Output.getsPointsFromTiebreak(player, increment);
    }
    private static void dealCards() {
        for(int i = 0; i < 52; i++) {
            if (i % 2 == 0)
                player1.draw(theDeck);
            else
                player2.draw(theDeck);
        }
    }
    public static void flipThreeCards(Player player) {
        player.flip();
        player.flip();
        player.flip();
    }
    public static boolean handsAreNotEmpty() {
        return player1.getHand().size() > 0;
    }
}