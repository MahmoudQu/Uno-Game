package com.mypackage.rules;
import com.mypackage.components.*;

public class ValueMatchStrategy implements PlayableStrategy {
    @Override
    public boolean canPlay(Card card, Card topCard) {
        return card.getValue().equals(topCard.getValue());
    }

}
