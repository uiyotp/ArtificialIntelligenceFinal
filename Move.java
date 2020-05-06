package DandB;
public class Move{
    private int[] play;
    private double score;
    public Move(){
    }

    public Move(int[] play, double score){
        this.play = play;
        this.score = score;
    }

    public int[] getPlay(){
        return play;
    }

    public double getScore(){
        return score;
    }

    public void setPlay(int[] play){
        this.play = play;
    }

    public void setScore(double score){
        this.score = score;
    }

    @Override 
    public String toString(){
        if(play==null){
            return "Go anywhere on the board.";
        }
        else{
            return String.format("%d, %d",play[0],play[1]);
        }
    }
}