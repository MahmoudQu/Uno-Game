package com.mypackage.rules;

import com.mypackage.components.Rule;
import com.mypackage.game.GameRules;

public class SkipTwoRule extends Rule {
    public SkipTwoRule() {
        super("Skip Two Rule");
    }

    @Override
    public GameRules apply(GameRules move) {
        move.skipTwoRule();
        return move;

    }
}
