package com.mypackage.rules;
import com.mypackage.game.GameRules;
import com.mypackage.components.Rule;

public class ReverseRule extends Rule {

    public ReverseRule() {
        super("Reverse");
    }


    @Override
    public GameRules apply(GameRules move) {
        move.reverseRule();
        return move;
    }
}
