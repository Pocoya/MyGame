package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackGroundStars
{
    private Sprite myTexture;
    private float myPosY;
    private float myPosX;
    private int myVelocity;

    Color myColor;

    public BackGroundStars(Texture aTexture, float aNewPosX, float aNewPosY, int aNewVel, Color aColor)
    {
        myTexture = new Sprite(aTexture);
        myPosY = aNewPosY;
        myPosX = aNewPosX;
        myVelocity = aNewVel;
        myColor = aColor;
        myTexture.setSize(20, 20);
        myTexture.setPosition(myPosX, myPosY);
    }


    public float GetPosY()
    {
        return myPosY;
    }
    public void Update(float deltaTime)
    {
        myPosY += myVelocity * deltaTime;
        myTexture.setPosition(myTexture.getX(), myPosY);
    }

    public void Draw(SpriteBatch aSpriteBatch)
    {
        myTexture.draw(aSpriteBatch);
    }
}
