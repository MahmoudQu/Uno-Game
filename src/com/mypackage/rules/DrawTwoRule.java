package com.mypackage.rules;
import com.mypackage.game.GameRules;
import com.mypackage.components.Rule;

public class DrawTwoRule extends Rule {

    public DrawTwoRule() {
        super("Draw Two");
    }

    @Override
    public GameRules apply(GameRules move) {
        move.drawTwoRule();
        return move;
    }
}
