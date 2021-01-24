package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
    int xPosition, zPosition, yPosition;
    int width, height;
    int lane;
    Sprite playerSprite;
    boolean isMovingLeft, isMovingRight;

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
        yPosition = -960;
        width = 360;
        height = 360;
    }

    void moveRight(){
        xPosition += 36;
    }

    void moveLeft(){ xPosition -= 36; }

    void Jump(){
        System.out.println("jump!");
        zPosition += 1;
    }

    void Dive(){
        System.out.println("dive!");
        zPosition -= 1;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() { return yPosition; }

    public int getzPosition() {
        return zPosition;
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        isMovingRight = movingRight;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
