package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackGroundStars
{
    private final Sprite myTexture;
    private float myPosY;
    private final int myVelocity;

    Color myColor;

    public BackGroundStars(Texture aTexture, float aNewPosX, float aNewPosY, int aNewVel, Color aColor) {
        myTexture = new Sprite(aTexture);
        myPosY = aNewPosY;
        myVelocity = aNewVel;
        myColor = aColor;
        myTexture.setSize(20, 20);
        myTexture.setPosition(aNewPosX, myPosY);
    }


    public float GetPosY() {
        return myPosY;
    }
    public void Update(float deltaTime) {
        myPosY += myVelocity * deltaTime;
        myTexture.setPosition(myTexture.getX(), myPosY);
    }

    public void Draw(SpriteBatch aSpriteBatch) {
        myTexture.draw(aSpriteBatch);
    }
}
