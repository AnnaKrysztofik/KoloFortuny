package main;

import main.models.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TheBestResult {

    public TheBestResult()  {


    }

    public static void checkAndSave(Player player){
        Player theBestPlayer = readResult();
        if (player.getPoints() > theBestPlayer.getPoints()) theBestPlayer = player;
        saveResult(theBestPlayer);
  }

    public static void saveResult(Player theBestPlayer)  {
        PrintWriter record = null;
        try {
            record = new PrintWriter("rekord.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            record.close();
        }

        record.println(theBestPlayer.getName() + "," + theBestPlayer.getPoints());
        record.close();
    }


    public static Player readResult() {
        Scanner readRecord = null;
        try {
            readRecord = new Scanner(new File("rekord.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String record = readRecord.nextLine();
        String[] player = record.split(",", 2);
        Integer.parseInt(player[1]);
        return  new Player(player[0],  Integer.parseInt(player[1]));
       }
}
