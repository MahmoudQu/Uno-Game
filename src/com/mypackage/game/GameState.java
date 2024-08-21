package com.mypackage.game;
import com.mypackage.components.*;
import java.util.*;
public class GameState {
    public List<Player> players;
    public static List<Card> discardPile;
    public Card card;
    public Deck deck;
    public int currentPlayerIndex;
    public String chosenColor;
    public boolean isClockwise;
    public GameState(){
        players =  new ArrayList<>();
        discardPile = new ArrayList<>();
        deck = new Deck();
        chosenColor = "";
        currentPlayerIndex  = 0;
        isClockwise = true;
    }
    public void drawCards(Player player, int numCards) {
        try {
            for (int i = 0; i < numCards; i++) {
                Card card = deck.drawCard();
                player.addCardToHand(card);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Card getTopCard(){
        return new Card(discardPile.get(discardPile.size()-1).getColor(),
                discardPile.get(discardPile.size() - 1).getValue());
    }
    public Player getNextPlayer() {
        updateCurrentPlayer();
        return players.get(currentPlayerIndex);
    }
    public String chooseColor() {
        Scanner scanner = new Scanner(System.in);
        Set<String> validColors = new HashSet<>();
        Collections.addAll(validColors, "red", "green", "blue", "yellow");
        System.out.println("Choose a color: red, green, blue or yellow");
        while (true) {
            String chosenColor = scanner.nextLine();
            if (validColors.contains(chosenColor)) {
                return chosenColor;
            } else {
                System.out.println("Invalid option! Choose a color from the given options.");
            }
        }
    }
    public void updateCurrentPlayer() {
        if (isClockwise) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }
    public void printCurrentPlayer(Player player) {
        System.out.println(player.getName() + "'s turn..\nCurrent card: " +
                discardPile.get(discardPile.size() - 1).getColor() + " " +
                discardPile.get(discardPile.size() - 1).getValue());
    }
    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidPlay(Card card) {
        Card currentCard = discardPile.get(discardPile.size() - 1);
        if (card.isWildCard()) {
            return true;
        }
        if (currentCard.isWildCard()) {
            return card.getColor().equalsIgnoreCase(chosenColor);
        }
        return card.getColor().equalsIgnoreCase(currentCard.getColor()) ||
                card.getValue().equalsIgnoreCase(currentCard.getValue());
    }

}
