package project.gameLogic;

public class Score {
    public int getCount() {
        return count;
    }

    private int count = 0;

    public int score (String s){
        count += s.length();
        System.out.println(count);
        return count;
    }
}
