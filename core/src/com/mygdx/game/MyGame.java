package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int posX = 500;
	int posY = 50;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("shooter.jpeg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		if(Gdx.input.isKeyPressed(Input.Keys.D))
		{
			posX += Gdx.graphics.getDeltaTime() * 100;
		} else if(Gdx.input.isKeyPressed(Input.Keys.A))
		{
			posX -= Gdx.graphics.getDeltaTime() * 100;
		}  else if(Gdx.input.isKeyPressed(Input.Keys.W))
		{
			posY += Gdx.graphics.getDeltaTime() * 100;
		} else if(Gdx.input.isKeyPressed(Input.Keys.S))
		{
			posY -= Gdx.graphics.getDeltaTime() * 100;
		}
		batch.draw(img, posX, posY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
