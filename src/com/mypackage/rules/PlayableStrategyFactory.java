package com.mypackage.rules;
import com.mypackage.components.*;
import java.util.*;
public class PlayableStrategyFactory {
    public static List<PlayableStrategy> createStrategies(Card card) {
        List<PlayableStrategy> strategies = new ArrayList<>();

        if (card.getColor().equals("Wild")) {
            strategies.add(new WildCardStrategy());
        } else {
            strategies.add(new ColorMatchStrategy());
            strategies.add(new ValueMatchStrategy());
        }

        return strategies;
    }
}

