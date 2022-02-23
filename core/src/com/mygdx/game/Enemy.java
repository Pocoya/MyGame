package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.graalvm.compiler.lir.sparc.SPARCMove;

public class Enemy {


    Sprite sprite;
    int maxX = 1000;
    int lowX = 100;

    int maxY = 700;
    int lowY = 100;

    float speed = 100;

    float posX;
    float posY;
    public Enemy() {
        sprite = new Sprite(new Texture("shooter.jpeg"));
        sprite.setPosition(500, 500);
        posX = sprite.getX();
        posY = sprite.getY();
    }

    public void Update(float deltaTime) {
        Movement(deltaTime);
    }

    public void Movement(float deltaTime) {
        posX += speed * deltaTime;
        if(posX >= maxX) {
            speed *= -1;
        }
        else if(posX <= lowX)
        {
            speed *= -1;
            posY -= sprite.getHeight();
        }

        sprite.setPosition(posX, posY);
    }

    public void Render(float deltaTime, SpriteBatch batch) {
        sprite.setSize(30, 30);
        sprite.setColor(Color.WHITE);
        sprite.draw(batch);
    }
}
