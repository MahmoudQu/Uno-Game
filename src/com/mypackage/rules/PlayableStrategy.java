package com.mypackage.rules;
import com.mypackage.components.*;
public interface PlayableStrategy {
    boolean canPlay(Card card, Card topCard);
}
