package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.Random;

public class ObstacleSpawner {
    ArrayList<Obstacle> obstacles;
    Texture obstacleImg;
    Random rnd;

    public ObstacleSpawner(){
        obstacles = new ArrayList<>();
        obstacleImg = new Texture("rock.jpg");
        rnd = new Random();
    }

    public void spawnObstacle(){
        int obstacleSetup = rnd.nextInt(6)+1;
        obstacles.add(new Obstacle (new Sprite(obstacleImg), 180, 1920, 0));
        if(obstacleSetup == 1 || obstacleSetup == 3 || obstacleSetup == 5){
        obstacles.add(new Obstacle (new Sprite(obstacleImg), 180, 1920, 0));
        }
        if(obstacleSetup == 2 || obstacleSetup == 3 || obstacleSetup == 6){
            obstacles.add(new Obstacle (new Sprite(obstacleImg), -180, 1920, 0));
        }
        if(obstacleSetup == 4 || obstacleSetup == 5 || obstacleSetup == 6){
            obstacles.add(new Obstacle (new Sprite(obstacleImg), -540, 1920, 0));
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }
}


