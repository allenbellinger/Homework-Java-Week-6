package com.promineotech;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private int score;
    private String name;

    public List<Card> getHand() {
        return this.hand;
    }
    public int getScore() {
        return score;
    }

    public String getName() {
        return this.name;
    }

    public Player(String name) {
        this.score = 0;
        this.name = name;
    }
    //I never used this method and didn't really find a good place for it to fit anyway, but I included it here
    //because it's part of the assignment.
    public void describe() {
        System.out.println("My name is " + name);
        System.out.println("My score is: " + score);
        for (Card card : hand)
            System.out.println(card.describe());
    }

    public Card flip() {
        return hand.remove(0);
    }

    public void draw(Deck deck) {
        this.hand.add(deck.draw());
    }

    public void incrementScore() {
        score++;
    }

}