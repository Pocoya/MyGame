package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.swing.*;
import java.io.File;

public class Player extends MyGame
{
    private int speed = 200;
    private int health;
    private int points;
    Sprite shooter;

    final float fireRate = 1;
    float fireTime = fireRate;

    private String playerName;

    Movement movement;
    HighScore highScore;
    FilePoints file;

    public Player()
    {
        movement = new Movement();
        shooter = new Sprite(new Texture("shooter.jpeg"));
        highScore = new HighScore();
        file = new FilePoints();
        //pName();
    }

    /*
    public void pName(){
        playerName = JOptionPane.showInputDialog("Name: ");
    }
     */

    public void Update(float deltaTime)
    {
        movement.move(speed);
        shooter.setPosition(movement.getPosX(), movement.getPosY());
        fireTime += deltaTime;
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && fireTime >= fireRate)
        {
            //INSTANTIATE BULLET
            fireTime = 5;
            GameScreen.bullets.add(new Bullet(movement.getPosX() + (int)shooter.getWidth()/5, movement.getPosY() + (int)shooter.getHeight()/2));
            points++;
            highScore.updateScore(points);
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
