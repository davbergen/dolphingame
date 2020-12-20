package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Player player;
	InputListener inputListener = new InputListener();
	
	@Override
	public void create () {
		camera = new OrthographicCamera(1080, 1920);
		batch = new SpriteBatch();
		img = new Texture("dolphin-prototype-1.0.png");
		player = new Player(-180, 0, new Sprite(img));
		Gdx.input.setInputProcessor(new GestureDetector(0.0f, 0.0f, 0.0f, 5f, inputListener));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		if(inputListener.getReadMovement() == 1){
			player.moveLeft();
			inputListener.setReadMovement(0);
		}
		else if(inputListener.getReadMovement() == -1){
			player.moveRight();
			inputListener.setReadMovement(0);
		}

		batch.begin();
		drawPlayer();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	private void drawPlayer(){
		batch.draw(player.getPlayerSprite(), player.getxPosition(), -960);
	}
}
