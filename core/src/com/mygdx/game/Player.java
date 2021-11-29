package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends MyGame
{
    int speed = 200;
    int health;
    Sprite shooter;


    Movement movement;


    public Player()
    {
        movement = new Movement();
        shooter = new Sprite(new Texture("shooter.jpeg"));
    }

    public void Update(float deltaTime)
    {
        movement.move(speed);
        shooter.setPosition(movement.getPosX(), movement.getPosY());

        if(Gdx.input.isKeyJustPressed(Input.Keys.E))
        {
            //INSTANTIATE BULLET
            GameScreen.bullets.add(new Bullet(movement.getPosX(), movement.getPosY()));

        }
    }

    public void Render(float deltaTime, SpriteBatch batch)
    {

        shooter.setSize(60, 70);
        shooter.setColor(Color.PINK);
        shooter.draw(batch);
    }

    public void TakeDamage(int aDamage)
    {
        health -= aDamage;
    }

}
