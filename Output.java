package com.promineotech;

import java.util.Scanner;

public class Output {
    private static final Scanner in = new Scanner(System.in);
    //introduction called when game starts
    public static void introduction() {
        System.out.println("Welcome to the game of War!");
        System.out.print("Please enter your name: ");
    }
    //createPlayer called to ask player for their name
    public static Player createPlayer() {
        return new Player(in.nextLine());
    }
    //Separate method for the first card flip to make the game flow better.
    public static void flipFirstCard() {
        System.out.print("Press enter to flip your first card:");
        in.nextLine();
    }
    //cards almost always used to describe the cards that were flipped last.
    public static void cards(Card card1, Card card2) {
        System.out.println("Your card: " + card1.getName());
        System.out.println("Computer's card: " + card2.getName());
    }
    //flipAnotherCard used for each card flip. I tried to make it feel like the player had input on what was going on
    //by making them press enter to go to the next step. I used a blank in.nextLine() to act like they actually were
    //doing something even though they can type whatever they want, but as long as they press enter, it goes to the
    //next instruction.
    public static void flipAnotherCard() {
        System.out.print("Press enter to flip another card:");
        in.nextLine();
        System.out.println();
    }
    public static void flipFourCardsForTiebreak() {
        System.out.print("Your cards are the same. Press enter to put down 3 cards and flip the fourth:");
        in.nextLine();
    }
    //Made the point output the same method. Used the fact that player2 is always Computer to say if player1 or
    //computer got the point.
    public static void getsOnePoint(Player player) {
        if (player.getName().equals("Computer"))
            System.out.println("The computer got a point.");
        else
            System.out.println("You got a point!");
    }
    //Same as getsOnePoint in that it knows if the computer or player1 got the point. The increment is how I've
    //implemented the tiebreak points. For each tie, the player that wins the tiebreak gets an additional three points
    //for each time that each player flips 3 cards. So, 1 point for the initial cards that are tied, 3 points for the
    //3 card flip, and another point for the next flip whether it's a tie or not. If it's a tie, you just repeat.
    public static void getsPointsFromTiebreak(Player player, int increment) {
        if (player.getName().equals("Computer"))
            System.out.println("The computer got " + increment + " points for that tiebreak.");
        else
            System.out.println("You got " + increment + " points for that tiebreak!");
    }
    //If there are less than 4 cards, then the tiebreak section can't work. The way I've made it work is that all the
    //previously drawn cards from the active tiebreak are just discarded, and the game continues as normal for the
    //rest of the cards. If there aren't any more cards at all, then the game finishes like normal.
    public static void notEnoughCardsForTiebreak() {
        System.out.println("There aren't enough cards to draw three cards and flip the fourth.");
        System.out.println("The previously drawn cards will be discarded.");
    }
    //Once game is over, outputs who won or if there's a tie, outputs each player's score, and then asks if the
    //player wants to play another game.
    public static boolean finishGame(Player player1, Player player2) {
        if(player1.getScore() > player2.getScore())
            System.out.println("You won!");
        else if(player2.getScore() > player1.getScore())
            System.out.println("I'm sorry, you didn't win this time.");
        else
            System.out.println("The game was a tie!");
        System.out.println("Your score: " + player1.getScore());
        System.out.println("Computer score: " + player2.getScore());
        System.out.print("Want to play again? (y/n)");
        String answer = in.nextLine();
        return answer.equalsIgnoreCase("y");
    }
}