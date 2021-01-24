package com.mygdx.game;

public class CollisionChecker {
    //TODO when add z-axis objects, make Colissionsno :)
    public boolean checkForCollision(Obstacle obs, Player player){
        if(player.getxPosition() < obs.getxPosition() + obs.getWidth() && player.getxPosition() + player.getWidth() > obs.getxPosition()
        && player.getyPosition() < obs.getyPosition() + obs.getHeight() && player.getyPosition() + player.getHeight() > obs.getyPosition() && player.getzPosition() == obs.getzPosition()){
            return true;
        }
        else{
            return false;
        }
    }
}
