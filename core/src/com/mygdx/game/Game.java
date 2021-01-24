package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.Timer;

import java.lang.*;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture playerImg;
	ObstacleSpawner obsSpawner;
	OrthographicCamera camera;
	CollisionChecker CC;
	Player player;
	InputListener inputListener = new InputListener();
	GameTimer jumpTimer = new GameTimer();
	GameTimer diveTimer = new GameTimer();
	GameTimer spawnTimer = new GameTimer();
	GameTimer worldTimer = new GameTimer();
	int moveCounter;
	float difficultySpeed;
	
	@Override
	public void create () {
		camera = new OrthographicCamera(1080, 1920);
		CC = new CollisionChecker();
		batch = new SpriteBatch();
		playerImg = new Texture("dolphin-prototype-1.0.png");
		obsSpawner = new ObstacleSpawner();
		player = new Player(-180, 0, new Sprite(playerImg));
		difficultySpeed = 1.0f;
		Gdx.input.setInputProcessor(new GestureDetector(0.0f, 0.0f, 0.0f, 5f, inputListener));
		spawnTimer.start();
		worldTimer.start();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		updatePlayer();
		updateObstacles();
		checkForInput();
		batch.begin();
		drawObstacles();
		drawPlayer();
		batch.end();
		if(spawnTimer.getDeltaTime() >= 2000-(10*difficultySpeed) && spawnTimer.getDeltaTime() > 1000){
			createObstacles();
		}
		if(worldTimer.getDeltaTime() >= 1000){
			difficultySpeed += 0.05f;
			worldTimer.start();
		}
	}

	private void createObstacles() {
		obsSpawner.spawnObstacle();
		spawnTimer.start();
	}

	private void updateObstacles() {

		if(obsSpawner.getObstacles() != null) {
			for (int i = 0; i < obsSpawner.getObstacles().size(); i++) {
				if(obsSpawner.getObstacles().get(i).yPosition < -1260) {
					obsSpawner.getObstacles().remove(i);
					System.out.println("removed obs");
				}
			}
			for (Obstacle obs : obsSpawner.getObstacles()) {
				if(CC.checkForCollision(obs, player)){
					gameOver();
				}
				obs.moveObstacle(difficultySpeed);
			}
		}

	}

	void checkForInput(){
		if(inputListener.getReadMovementX() == 1){
			processCommand("left");
			inputListener.setReadMovementX(0);
		}
		else if(inputListener.getReadMovementX() == -1){
			processCommand("right");
			inputListener.setReadMovementX(0);
		}
		else if(inputListener.getReadMovementY() == 1){
			processCommand("jump");
			inputListener.setReadMovementY(0);
		}
		else if(inputListener.getReadMovementY() == -1){
			processCommand("dive");
			inputListener.setReadMovementY(0);
		}
	}

	public void processCommand(String command){
		switch (command){
			case "left":
				if(player.xPosition == 180 || player.xPosition == -180) {
					player.setMovingLeft(true);
				}
				break;
			case "right":
				if(player.xPosition == -540 || player.xPosition == -180) {
					player.setMovingRight(true);
				}

				break;
			case "jump":
				if(player.zPosition == 0){
					player.Jump();
					jumpTimer.start();
				}
				else if(player.zPosition == -1){
					player.Jump();
				}
				break;
			case "dive":
				if(player.zPosition == 0){
					player.Dive();
					diveTimer.start();
				}
				else if(player.zPosition == 1){
					player.Dive();
				}
				break;
		}
	}

	public void updatePlayer(){
		if(player.isMovingLeft && moveCounter < 10){
			player.moveLeft();
			moveCounter++;
		}
		else if(player.isMovingRight && moveCounter < 10){
			player.moveRight();
			moveCounter++;
		}
		else{
			moveCounter = 0;
			player.setMovingLeft(false);
			player.setMovingRight(false);
		}
		if(player.zPosition == 1 && jumpTimer.getDeltaTime() >= 1000){
			player.Dive();
		}
		else if(player.zPosition == -1 && diveTimer.getDeltaTime() >= 1000){
			player.Jump();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerImg.dispose();
		for(Obstacle obs : obsSpawner.getObstacles()){
			obs.getObstacleSprite().getTexture().dispose();
		}

	}

	private void drawPlayer(){
		batch.draw(player.getPlayerSprite(), player.getxPosition(), player.getyPosition());
	}

	private void drawObstacles(){
		for(Obstacle obstacle : obsSpawner.getObstacles()) {
			batch.draw(obstacle.getObstacleSprite(), obstacle.getxPosition(), obstacle.getyPosition());
		}
	}

	private void gameOver(){
		Gdx.app.exit();
	}
}
