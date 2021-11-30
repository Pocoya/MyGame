package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Random;

public class StarGenerator
{
    Texture texture;
    float spawnWidth;
    float density;
    float dirX;
    float dirY;
    Color color = Color.WHITE;

    ArrayList<BackGroundStars> stars = new ArrayList<>();

    float time;
    Random rng, rng2;
    int speed;


    public StarGenerator(Texture newTexture, float aSpawnWidth, float aDensity)
    {
        texture = newTexture;
        spawnWidth = aSpawnWidth;
        density = aDensity;



        rng = new Random();
        rng2 = new Random();

        for(int i = 0; i < 100; i++)
        {
            int tmp = getRandomNumber(1,4);
            if(tmp == 1)
            {
                speed = 150;
            }
            else if(tmp == 2)
            {
                speed = 200;
            }

            stars.add(new BackGroundStars(texture, getRandomNumber(1, 1100), getRandomNumber(1, 650), speed, color));
        }
    }

    public void Update()
    {

    }

    public void Render()
    {

    }

    public void CreateNewStar()
    {

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
