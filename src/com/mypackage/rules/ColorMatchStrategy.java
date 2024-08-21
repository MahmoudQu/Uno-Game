package com.mypackage.rules;
import com.mypackage.components.*;

public class ColorMatchStrategy implements PlayableStrategy {
    @Override
    public boolean canPlay(Card card, Card topCard) {
        return card.getColor().equals(topCard.getColor());
    }
}