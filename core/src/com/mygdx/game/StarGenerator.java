package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

public class StarGenerator {
    Texture texture;
    float spawnWidth;
    float density;
    float dirX;
    float dirY;
    Color color = Color.WHITE;

    ArrayList<BackGroundStars> stars = new ArrayList<>();

    float time;
    Random rng;
    int speed;


    public StarGenerator(Texture newTexture, float aSpawnWidth, float aDensity) {
        texture = newTexture;
        spawnWidth = aSpawnWidth;
        density = aDensity;
        rng = new Random();

        for(int i = 0; i < 100; i++) {
            int tmp = getRandomNumber(1,3);
            if(tmp == 1) {
                speed = 50;
            }
            else if(tmp == 2) {
                speed = 100;
            }

            stars.add(new BackGroundStars(texture, getRandomNumber(100, 1100), getRandomNumber(1, 650), speed, color));
        }
    }

    public void Update(float deltaTime) {
        time += deltaTime;

        while(time > 0) {
            time -= 1/density;
            CreateNewStar();
        }

        for(int i = 0; i < stars.size(); i++) {
            stars.get(i).Update(deltaTime);

            if(stars.get(i).GetPosY() > 750) {
                stars.remove(i);
                i--;
            }
        }
    }

    public void Render(SpriteBatch batch) {
        for (BackGroundStars s: stars) {
           s.Draw(batch);
        }
    }

    public void CreateNewStar() {
        double any = rng.nextDouble();
        int tmpSpeed = getRandomNumber(1,3);

        if(tmpSpeed == 1) {
            speed = 50;
        }
        else if(tmpSpeed == 2) {
            speed = 100;
        }
        stars.add(new BackGroundStars(texture, (float)rng.nextDouble() * spawnWidth, -20, speed, color));
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
