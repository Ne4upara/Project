package project.gameLogic;

import lombok.Getter;
import lombok.Setter;

public class ScoreCounter {
    @Getter
    @Setter
    private int playerScore = 0;
    @Getter
    @Setter
    private int computerScore = 0;
    private int count = 0;

    public int counterScore(String word) {
        count ++;
        if (count % 2 == 0)return  computerScore += word.length();
        else return playerScore += word.length();
    }

    public String vinnerOrLose (){
        if (playerScore > computerScore) return "vin";
        else return "lose";
    }
}




