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
        return String.format("Play: %d, %d Score: %f",play[0],play[1],score);
    }
}