package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends MyGame {
    Sprite bullet;
    private int posY;
    private float timeAlive;

    boolean isAlive = true;

    public Bullet(int startPosX, int startPosY) {
        bullet = new Sprite(new Texture(("bu.png")));
        posY = startPosY;
        bullet.setPosition(startPosX, posY);
    }

    public void Update(float deltaTime) {
        timeAlive += deltaTime;
        // fly straight up, delete if not hit in long time.
        posY += 150 * deltaTime;
        bullet.setPosition(bullet.getX(), posY);

        if(timeAlive > 4) {
            isAlive = false;
        }
    }

    public void Render(float deltaTime, SpriteBatch batch) {
        bullet.setSize(35,20);
        bullet.setColor(Color.GRAY);
        bullet.draw(batch);
    }
}
