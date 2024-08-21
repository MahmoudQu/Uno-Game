package com.mypackage.game;
import com.mypackage.rules.*;

public class UnoGame extends Game{

    public UnoGame(){
        super(new GameRules());

        addRule(new WildDrawFourRule());
        addRule(new WildRule());
        addRule(new ReverseRule());
        addRule(new SkipRule());
        addRule(new DrawTwoRule());
        addRule(new SkipTwoRule());
        // this skip two rule can be used if a developer want to
        // add this skip two rule, this rule is simply switch the turn two times
    }

    @Override
    public void play(){
        super.initializeGame();
        super.play();
    }
}
