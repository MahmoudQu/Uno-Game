package com.mypackage.game;

import com.mypackage.components.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Game implements IGame {
    private List<Rule> rules = new ArrayList<>();
    private GameRules move;
    public Game(GameRules gameRules){
        move = gameRules;
    }
    public void addRule(Rule rule){
        rules.add(rule);
    }
    public void handleCardEffect(Card card) {
        move.card = card;
        for (Rule rule : rules) {
            if(Objects.equals(card.getValue(), rule.getRuleName()))
                 move= rule.apply(move);
        }
    }

    public void initializeGame() {
        System.out.println("Game started..");

        Scanner scanner = new Scanner(System.in);
        int numOfPlayers = 0;

        while (numOfPlayers <= 1) {
            System.out.print("Enter the number of players (2 or higher): ");
            numOfPlayers = scanner.nextInt();

            if (numOfPlayers <= 1) {
                System.out.println("Invalid number! try 2 or higher: ");
            }
        }
        scanner.nextLine();
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String playerName = scanner.nextLine();
            move.players.add(new Player(playerName));
        }

        move.deck.shuffle();

        Card firstCard = move.deck.drawCard();
        while (firstCard.isWildCard()) {
            firstCard = move.deck.drawCard();
        }
        move.discardPile.add(firstCard);

        for (Player player : move.players) {
            for (int i = 0; i < 7; i++) {
                Card card = move.deck.drawCard();
                player.addCardToHand(card);
            }
        }
    }
    public void play() {

        Scanner scanner = new Scanner(System.in);

        while (move.isGameOver()) {
            Player currentPlayer = move.players.get(move.currentPlayerIndex);

            move.printCurrentPlayer(currentPlayer);
            System.out.println("Player's Hand: " + currentPlayer.getHand());

            boolean validPlay = false;

            while (!validPlay) {
                System.out.println("Choose a card index to play , or enter -1 to draw a card: ");
                Card topCard=move.getTopCard();
                List<Card>playableCards = PlayableCards.getPlayableCards(currentPlayer.getHand(),topCard);
                if(!playableCards.isEmpty()){
                    System.out.println("You can play the following cards:");
                    for (Card card : playableCards) {
                        System.out.println(card);
                    }
                    System.out.println("Choose the card index from player's hand.");
                }else{
                    System.out.println("You have no cards to play, choose -1 to draw a card.");
                }

                int cardIndex = scanner.nextInt();

                if (cardIndex == -1) {
                    Card drawnCard = move.deck.drawCard();
                    if (drawnCard != null) {
                        currentPlayer.addCardToHand(drawnCard);
                        System.out.println(currentPlayer.getName() + " drew a card: " + drawnCard.getColor() + " " + drawnCard.getValue());
                    } else {
                        System.out.println("No more cards in the deck!");
                    }
                    validPlay = true;
                } else if (cardIndex >= 0 && cardIndex < currentPlayer.getHand().size()) {
                    Card selectedCard = currentPlayer.playCard(cardIndex);

                    if (move.isValidPlay(selectedCard)) {
                        validPlay = true;
                        move.discardPile.add(selectedCard);
                        System.out.println(currentPlayer.getName() + " played: " + selectedCard.getColor() + " " + selectedCard.getValue());

                        handleCardEffect(selectedCard);

                        if (currentPlayer.getHand().isEmpty()) {
                            System.out.println("\n\n");
                            System.out.println("UNO! " + currentPlayer.getName() + " wins!");
                            break;
                        }
                    } else {
                        System.out.println("Invalid play! Try again.");
                        currentPlayer.addCardToHand(selectedCard);
                    }
                } else {
                    System.out.println("Invalid index! Try again.");
                }
            }
            if (move.isGameOver()) {
                move.updateCurrentPlayer();
            }
        }
        scanner.close();
    }

}


