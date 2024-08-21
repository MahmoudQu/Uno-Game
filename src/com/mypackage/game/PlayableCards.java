package com.mypackage.game;
import java.util.*;
import com.mypackage.components.*;
import com.mypackage.rules.*;

public class PlayableCards {
    public static List<Card> getPlayableCards(List<Card> hand, Card topCard) {
        List<Card> playableCards = new ArrayList<>();

        for (Card card : hand) {
            List<PlayableStrategy> strategies = PlayableStrategyFactory.createStrategies(card);
            for (PlayableStrategy strategy : strategies) {
                if (strategy.canPlay(card, topCard)) {
                    playableCards.add(card);
                    break;
                }
            }
        }
        return playableCards;
    }
}