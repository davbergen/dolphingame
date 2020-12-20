package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
    int xPosition, zPosition;
    Sprite playerSprite;

    /**
     * Constructor for player class
     * @param xPosition
     * @param zPosition
     * @param playerSprite
     */
    public Player(int xPosition, int zPosition, Sprite playerSprite){
        this.xPosition = xPosition;
        this.zPosition = zPosition;
        this.playerSprite = playerSprite;

    }

    void moveRight(){
        if(xPosition < 180){
            xPosition += 360;
        }
    }

    void moveLeft(){
        if(xPosition >= -180){
            xPosition -= 360;
        }
    }

    void Jump(){

    }

    void Dive(){

    }

    public int getxPosition() {
        return xPosition;
    }

    public int getzPosition() {
        return zPosition;
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }
}
