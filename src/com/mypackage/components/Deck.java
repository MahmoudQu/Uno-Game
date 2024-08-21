package com.mypackage.components;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "Skip", "Skip Two","Reverse", "Draw Two"};

        initializeNumberCard(colors,values);
        initializeActionCard(colors);
        initializeWildCard();
    }

    private void initializeWildCard() {
        for (int i = 0; i < 4; i++) {
            cards.add(new Card("Wild", "Wild"));
            cards.add(new Card("Wild", "Wild Draw Four"));
        }
    }
    private void initializeNumberCard(String[] colors,String[] values){
        for(String color : colors) {
            for (String value : values) {
                cards.add(new Card(color, value));
            }
        }
    }
    private void initializeActionCard(String[] colors){
        for(String color : colors) {
            for (int i = 0; i < 2; i++) {
                cards.add(new Card(color, "Skip"));
                cards.add(new Card(color, "Reverse"));
                cards.add(new Card(color, "Draw Two"));
                cards.add(new Card(color, "Skip Two")); // new variation , card that skip the turn two times
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards);
    }
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.removeLast();
    }
}