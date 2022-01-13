package com.promineotech;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    public List<Card> getCards() {
        return this.cards;
    }

    private List<Card> cards = new ArrayList<>();

    //constructor
    public Deck() {
        //Hearts
        cards.add(new Card(2, "Two of Hearts"));
        cards.add(new Card(3, "Three of Hearts"));
        cards.add(new Card(4, "Four of Hearts"));
        cards.add(new Card(5, "Five of Hearts"));
        cards.add(new Card(6, "Six of Hearts"));
        cards.add(new Card(7, "Seven of Hearts"));
        cards.add(new Card(8, "Eight of Hearts"));
        cards.add(new Card(9, "Nine of Hearts"));
        cards.add(new Card(10, "Ten of Hearts"));
        cards.add(new Card(11, "Jack of Hearts"));
        cards.add(new Card(12, "Queen of Hearts"));
        cards.add(new Card(13, "King of Hearts"));
        cards.add(new Card(14, "Ace of Hearts"));

        //Diamonds
        cards.add(new Card(2, "Two of Diamonds"));
        cards.add(new Card(3, "Three of Diamonds"));
        cards.add(new Card(4, "Four of Diamonds"));
        cards.add(new Card(5, "Five of Diamonds"));
        cards.add(new Card(6, "Six of Diamonds"));
        cards.add(new Card(7, "Seven of Diamonds"));
        cards.add(new Card(8, "Eight of Diamonds"));
        cards.add(new Card(9, "Nine of Diamonds"));
        cards.add(new Card(10, "Ten of Diamonds"));
        cards.add(new Card(11, "Jack of Diamonds"));
        cards.add(new Card(12, "Queen of Diamonds"));
        cards.add(new Card(13, "King of Diamonds"));
        cards.add(new Card(14, "Ace of Diamonds"));

        //Clubs
        cards.add(new Card(2, "Two of Clubs"));
        cards.add(new Card(3, "Three of Clubs"));
        cards.add(new Card(4, "Four of Clubs"));
        cards.add(new Card(5, "Five of Clubs"));
        cards.add(new Card(6, "Six of Clubs"));
        cards.add(new Card(7, "Seven of Clubs"));
        cards.add(new Card(8, "Eight of Clubs"));
        cards.add(new Card(9, "Nine of Clubs"));
        cards.add(new Card(10, "Ten of Clubs"));
        cards.add(new Card(11, "Jack of Clubs"));
        cards.add(new Card(12, "Queen of Clubs"));
        cards.add(new Card(13, "King of Clubs"));
        cards.add(new Card(14, "Ace of Clubs"));

        //Spades
        cards.add(new Card(2, "Two of Spades"));
        cards.add(new Card(3, "Three of Spades"));
        cards.add(new Card(4, "Four of Spades"));
        cards.add(new Card(5, "Five of Spades"));
        cards.add(new Card(6, "Six of Spades"));
        cards.add(new Card(7, "Seven of Spades"));
        cards.add(new Card(8, "Eight of Spades"));
        cards.add(new Card(9, "Nine of Spades"));
        cards.add(new Card(10, "Ten of Spades"));
        cards.add(new Card(11, "Jack of Spades"));
        cards.add(new Card(12, "Queen of Spades"));
        cards.add(new Card(13, "King of Spades"));
        cards.add(new Card(14, "Ace of Spades"));
    }

    public void shuffle() {
        for(int i = 51; i > 0; i--) {
            Random r = new Random();
            int j = r.nextInt(i);

            Card tempCard = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, tempCard);
        }
    }

    public Card draw() {
        return cards.remove(0);
    }
}