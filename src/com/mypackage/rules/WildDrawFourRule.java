package com.mypackage.rules;

import com.mypackage.components.Rule;
import com.mypackage.game.GameRules;

public class WildDrawFourRule extends Rule {

    public WildDrawFourRule() {
        super("Wild Draw Four");
    }

    @Override
    public GameRules apply(GameRules move) {
        move.wildDrawFourRule();
        return move;
    }
}
