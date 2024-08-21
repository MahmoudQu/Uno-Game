package com.mypackage.components;

import java.util.ArrayList;
import java.util.List;
public class Player {
    private String name;
    private List<Card> hand;
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public List<Card> getHand() {
        return hand;
    }
    public void addCardToHand(Card card) {
        hand.add(card);
    }
    public Card playCard(int index) {
        try {
            return hand.remove(index);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}