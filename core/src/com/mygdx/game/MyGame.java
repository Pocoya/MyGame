package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private Movement movement;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("shooter.jpeg");
		movement = new Movement();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		movement.move();
		batch.draw(img, movement.getPosX(), movement.getPosY());
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}