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
    public void write(String playerName, int points){
        file.writeToFile(playerName, HighScore.points);
    }
    public int getScore(){
        return points;
    }
}
