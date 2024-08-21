package com.mypackage.rules;
import com.mypackage.game.GameRules;
import com.mypackage.components.Rule;

public class SkipRule extends Rule {

    public SkipRule() {
        super("Skip");
    }


    @Override
    public GameRules apply(GameRules move) {
        move.skipRule();
        return move;
    }
}
