package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Movement extends MyGame{
    int posX = 500;
    int posY = 50;

    private int points;
    HighScore highScore;
    public Movement(){
        super();
        highScore = new HighScore();
        points = 0;
    }

    public void move(){
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            posX += Gdx.graphics.getDeltaTime() * 200;
            points++;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            posX -= Gdx.graphics.getDeltaTime() * 200;
            points++;
        }  else if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            posY += Gdx.graphics.getDeltaTime() * 200;
        } else if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            posY -= Gdx.graphics.getDeltaTime() * 200;
        }

        highScore.updateScore(points);
        //The shooter's limitation
        if(getPosX() >= 1000){
            posX = 1000;
        } else if(getPosX() <= 0){
            posX = 0;
        } else if(getPosY() >= 120){
            posY = 120;
        } else if(getPosY() <= 0){
            posY = 0;
        }
    }

    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
}