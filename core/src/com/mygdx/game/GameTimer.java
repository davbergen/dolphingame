package com.mygdx.game;

import com.badlogic.gdx.utils.TimeUtils;

public class GameTimer {
    long startTime;
    long elapsedTime;

    public GameTimer(){}

    public void start(){
        startTime = TimeUtils.millis();
    }
    public long getDeltaTime(){
        elapsedTime = TimeUtils.millis();
        long deltaTime = elapsedTime - startTime;
        return deltaTime;
    }
}
