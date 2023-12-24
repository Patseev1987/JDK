package org.example.sem6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ParadoxMonroGame {
    private final int numberOfGames;
    private final boolean changeDoor;
    private final Map<Integer,String > results = new HashMap<>();
    private final Random random = new Random();
    private final String WINNER = "Winner";
    private final String LOSER = "Loser";

    public ParadoxMonroGame(int numberOfGames, boolean changeDoor) {
        this.numberOfGames = numberOfGames;
        this.changeDoor = changeDoor;
    }

    private void play(){
        for (int i = 0; i < numberOfGames; i++) {
            int winnerDoor = random.nextInt(1, 4);
            int gamerChoice = random.nextInt(1, 4);
            int presenterChoice = getPresenterChoice(winnerDoor, gamerChoice);
            if (changeDoor) {
                gamerChoice = getNewGamerChoice(gamerChoice, presenterChoice);
            }
            if (winnerDoor == gamerChoice){
                results.put(i,WINNER);
            }else {
                results.put(i,LOSER);
            }
        }
    }


    public void getInfo(){
        play();
        int winnerCounter = 0;
        int loserCounter = 0;
        for (var entry: results.entrySet()){
            if (entry.getValue().equals(WINNER)){
                winnerCounter++;
            }else{
                loserCounter++;
            }
        }

        if (changeDoor){
            System.out.printf("Gamer played %d times with door change.\nGamer won %d times (%.0f%%).\nGamer lost %d times (%.0f%%).\n"
                    ,numberOfGames, winnerCounter,((winnerCounter/(double) numberOfGames)*100)
                    ,loserCounter,((loserCounter/(double) numberOfGames)*100));
        }else {
            System.out.printf("Gamer played %d times without door change.\nGamer won %d times (%.0f%%).\nGamer lost %d times (%.0f%%).\n"
                    ,numberOfGames, winnerCounter,((winnerCounter/(double) numberOfGames)*100)
                    ,loserCounter,((loserCounter/(double) numberOfGames)*100));
        }
    }

    private int getNewGamerChoice(int gamerChoice, int presenterChoice) {
        int newGamerChoice = 1;
        for (int i = 0; i < 3; i++) {
            if (newGamerChoice != presenterChoice && newGamerChoice!= gamerChoice){
                break;
            }else {
                newGamerChoice++;
            }
        }
        return newGamerChoice;
    }

    public int getPresenterChoice(int winnerDoor, int gamerChoice) {
        int presenterChoice = 1;
        for (int i = 0; i < 3; i++) {
            if (presenterChoice!=winnerDoor && presenterChoice!=gamerChoice){
                break;
            }else {
                presenterChoice++;
            }
        }
        return presenterChoice;
    }
}
