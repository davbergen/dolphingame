package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Obstacle {
    int xPosition, yPosition, zPosition;
    Sprite obstacleSprite;

    public Obstacle(Sprite obstacleSprite,int xPosition, int yPosition, int zPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition;
        this.obstacleSprite = obstacleSprite;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getzPosition() {
        return zPosition;
    }

    public Sprite getObstacleSprite() {
        return obstacleSprite;
    }

    public void moveObstacle(float multiplier){
        int base = 10;
        yPosition -= base * multiplier;
    }
}
