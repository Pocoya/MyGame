package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends MyGame
{
    Sprite bullet;
    int posY = 50;
    public Bullet()
    {
        bullet = new Sprite(new Texture(("bullet.jpeg")));
    }

    public void Update(float deltaTime)
    {
        // fly straight up, delete if not hit in long time.
        posY += 150 * deltaTime;
        bullet.setPosition(bullet.getX(), posY);
    }

    public void Render(float deltaTime, SpriteBatch batch)
    {
        bullet.setScale(0.1f);
        bullet.setColor(Color.GRAY);
        bullet.draw(batch);
    }
}
