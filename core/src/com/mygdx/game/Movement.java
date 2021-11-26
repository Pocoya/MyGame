package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Movement extends MyGame{

    int posX = 500;
    int posY = 50;

    public Movement(){
        super();
    }

    public void move(){
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
    }

    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
}
