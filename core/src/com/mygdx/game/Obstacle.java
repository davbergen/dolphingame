package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Obstacle {
    int xPosition, yPosition, zPosition;
    int height, width;
    Sprite obstacleSprite;

    public Obstacle(Sprite obstacleSprite,int xPosition, int yPosition, int zPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition;
        this.obstacleSprite = obstacleSprite;
        height = 360; //change if add more obstacles :)
        width = 360;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
