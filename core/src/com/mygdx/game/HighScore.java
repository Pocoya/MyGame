package com.mygdx.game;

public class HighScore {
    private static int points;

    FilePoints file;
    public HighScore(){
        file = new FilePoints();
    }
    public void updateScore(int points){
        HighScore.points = points;
    }
    public void Write(){
        file.writeToFile(points);
    }
    public int getScore(){
        return points;
    }
}
