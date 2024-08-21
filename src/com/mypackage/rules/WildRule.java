package com.mypackage.rules;
import com.mypackage.game.GameRules;
import com.mypackage.components.Rule;

public class WildRule extends Rule {

    public WildRule() {
        super("Wild");
    }
    @Override
    public GameRules apply(GameRules move) {
        move.wildRule();
        return move;

    }
}
