package DandB;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;
import java.util.Random;
public class PlayGame{
    public static void main(String args[]){
    	
        Random rand = new Random();
        String First = "";
        Scanner input = new Scanner(System.in);
        int[] userPlay = {-1,-1};
        Page1 window = new Page1();
        Player user = new Player("user");
        Player COM = new Player("COM");
        Player[] players = {user,COM};
        Player[][] boxes = {{null,null},{null,null}};
        int[][] board = {
                {0,0},
                {0,0,0},
                {0,0},
                {0,0,0},
                {0,0}
            };

        State currentState;
        //System.out.println("Do you want to go first? (yes or no) NOTE: If you do not go first, then the game will be harder to win.");
        switch(First){
            case "yes":
            currentState = new State(board, boxes, players, user);
            break;
            default:
            currentState = new State(board, boxes, players, COM);
        while(!currentState.isTerminal()){
            int[][] getMoves = currentState.getMoves();
            switch(currentState.getCurrentPlayer().getName()){
                case "user":
                System.out.println("--------------------------------------------------");
                System.out.println(currentState);
                if(practiceMode.GetPracticeMode()){
                    if(firstMove.GetFirstMove()){
                        //Ran the program with 12 depth and waited 5 minutes for the best move.  It was 4,1 and then I chose the three equivalent moves
                        //and added them to the possible moves array to speed up the program on the first iteration
                        int[][] possibleMoves = {{0,0},{1,2},{3,0},{4,1}};
                        move.setMove(rand.nextInt(possibleMoves.length)); 
                        Move recentMove = new Move(possibleMoves[move.GetMove()],0);
                        firstMove.setFirstMove(false);;
                        System.out.println("This is what the computer would do in your situation: "+recentMove);
                    }
                    else if(getMoves.length<10){
                        Move bestMove = MiniMax.MiniMax(currentState, user, Double.MIN_VALUE, Double.MAX_VALUE);
                        System.out.println("This is what the computer would do in your situation: "+bestMove);
                    }else{
                        System.out.println("The computer would make a random move");
                    }
                }
                System.out.println("Which row do you want to make a move on? (0-4)");
                int x = input.nextInt();
                userPlay[0] = x;
                System.out.println("Which col do you want to make a move on? (0-1 OR 0-2)");
                int y = input.nextInt();
                userPlay[1] = y;
                currentState.makeMove(userPlay);
                firstMove.setFirstMove(false);;
                break;
                case "COM":
                if(currentState.getCurrentPlayer().getName().equals("COM")){
                    if(firstMove.GetFirstMove()==true){
                        //Ran the program with 12 depth and waited 5 minutes for the best move.  It was 4,1 and then I chose the three equivalent moves
                        //and added them to the possible moves array to speed up the program on the first iteration
                        int[][] possibleMoves = {{0,0},{1,2},{3,0},{4,1}};
                        move.setMove(rand.nextInt(possibleMoves.length));
                        currentState.makeMove(possibleMoves[move.GetMove()]);
                        Move recentMove = new Move(possibleMoves[move.GetMove()],0);
                        System.out.println("The computer made the move: "+recentMove.toString());
                        firstMove.setFirstMove(false);;
                    }else if(getMoves.length<10){
                        Move bestMove = MiniMax.MiniMax(currentState, COM, Double.MIN_VALUE, Double.MAX_VALUE);
                        currentState.makeMove(bestMove.getPlay());
                        System.out.println("The computer made the move: "+bestMove.toString());
                    }else{
                        move.setMove(rand.nextInt(getMoves.length));
                        currentState.makeMove(getMoves[move.GetMove()]);
                        Move recentMove = new Move(getMoves[move.GetMove()],0);
                        System.out.println("The computer made the move: "+recentMove.toString());
                    }
                }
                break;
                default:
                System.out.println("Pigs can fly!");
            }
        }
        int userScore = currentState.evaluate(user);
        int COMScore = currentState.evaluate(COM);
        System.out.println("--------------------------------------------------");
        System.out.println(currentState);
        System.out.println("You got "+userScore+" box(es) and your opponent got "+COMScore+ " box(es)!");
        if(userScore > COMScore){
            System.out.println("You Won!!!");
        }else if(userScore == COMScore){
            System.out.println("It's a tie...");
        }else{
            System.out.println("You Lose :(");
        }
    }
    public static void Pmode(String I) {
         switch(I){
              case "yes":
            	  practiceMode.setPracticeMode(true);
              break;
              default:
              practiceMode.setPracticeMode(false);
          }
    }
    public void Fmove(String Fmove) {
    	switch(Fmove){
            case "yes":
            StateString.setString("Yes");
            break;
            default:
            StateString.setString("Yes");
        }
    }
    
    
    public static class move{
    	private static int var =0;
    	
    	public static int GetMove() {
    		return move.var;
    	}
    	public static void setMove(int val) {
    		move.var = val;
    	}
    }
    public static class StateString{
    	private static String var ="yes";
    	
    	public static String GetStateString() {
    		return StateString.var;
    	}
    	public static void setString(String val) {
    		StateString.var = val;
    	}
    }
    public static class practiceMode{
    	private static boolean var = true;
    	
    	public static boolean GetPracticeMode() {
    		return practiceMode.var;
    	}
    	public static void setPracticeMode(boolean val) {
    		practiceMode.var = val;
    	}
    }
    public static class firstMove{
    	private static boolean var = true;
    	
    	public static boolean GetFirstMove() {
    		return firstMove.var;
    	}
    	public static void setFirstMove(boolean val) {
    		firstMove.var = val;
    	}
    }
}
    
