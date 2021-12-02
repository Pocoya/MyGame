package com.mygdx.game;
import java.io.*;
import java.util.Scanner;

public class FilePoints {
    private String fileName = "SavingPoints";
    public FilePoints(){
        createFile();
    }

    public void createFile(){
        File file = new File(fileName);
        try{
            if(file.createNewFile()){
                System.out.println("File created" + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(int score){
        try {
            try (PrintWriter fw = new PrintWriter(new FileWriter(fileName, true))){
                fw.write(score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Not finished, will come back to this later
    public void readFromFile(){
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
