package com.mygdx.game;

public class HighScore {
    private static int points;

    public HighScore(){
    }
    public void updateScore(int points){
        HighScore.points = points;
    }
    public int getScore(){
        return points;
    }
}
