package com.mygdx.game;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class InputListener implements GestureDetector.GestureListener {
    private int readMovementX = 0;
    private int readMovementY = 0;
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        if(velocityX < 0 && Math.abs(velocityX) > Math.abs(velocityY)) readMovementX = 1; //should move right
        else if(velocityX > 0 && Math.abs(velocityX) > Math.abs(velocityY)) readMovementX = -1; //should move left
        else if(velocityY < 0 && Math.abs(velocityY) > Math.abs(velocityX)) readMovementY = 1; //should move right
        else if(velocityY > 0 && Math.abs(velocityY) > Math.abs(velocityX)) readMovementY = -1; //should move left
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }

    public int getReadMovementX() {
        return readMovementX;
    }

    public void setReadMovementX(int readMovementX) {
        this.readMovementX = readMovementX;
    }

    public int getReadMovementY() {
        return readMovementY;
    }

    public void setReadMovementY(int readMovementY) {
        this.readMovementY = readMovementY;
    }
}
