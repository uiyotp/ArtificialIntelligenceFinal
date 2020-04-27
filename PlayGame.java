import java.util.Scanner;
import java.util.Random;
public class PlayGame{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[][] board = {
                {0,0},
                {0,0,0},
                {0,0},
                {0,0,0},
                {0,0}
            };
        int[] userPlay = {-1,-1};
        Player user = new Player("user");
        Player COM = new Player("COM");
        Player[] players = {user,COM};
        Player[][] boxes = {{null,null},{null,null}};
        State currentState = new State(board, boxes, players, user);
        System.out.println("--------------------------------------------------");
        System.out.println(currentState);
        while(!currentState.isTerminal()){
            switch(currentState.getCurrentPlayer().getName()){
                case "user":
                System.out.println("Which row do you want to make a move on?");
                int x = input.nextInt();
                userPlay[0] = x;
                System.out.println("Which col do you want to make a move on?");
                int y = input.nextInt();
                userPlay[1] = y;
                currentState.makeMove(userPlay);
                System.out.println("--------------------------------------------------");
                System.out.println(currentState);
                case "COM":
                if(currentState.getCurrentPlayer().getName().equals("COM")){
                    System.out.println("Press enter to start the COM's move... (Might have to press twice)");
                    input.nextLine();
                    input.nextLine();
                    Move bestMove = MiniMax.MiniMax(currentState, COM, 4, 0);
                    System.out.println(bestMove.toString());
                    if(bestMove.getPlay() == null){
                        int[][] possibleMoves = currentState.getMoves();
                        Random rand = new Random();
                        int move = rand.nextInt(possibleMoves.length);
                        currentState.makeMove(possibleMoves[move]);
                    }else{
                        currentState.makeMove(bestMove.getPlay());
                    }
                    System.out.println("--------------------------------------------------");
                    System.out.println(currentState);
                }
                default:
            }
        }
        int userScore = currentState.evaluate(user);
        int COMScore = currentState.evaluate(COM);
        System.out.println("You got "+userScore+" box(es) and your opponent got "+COMScore+ " box(es)!");
        if(userScore > COMScore){
            System.out.println("You Won!!!");
        }else if(userScore == COMScore){
            System.out.println("It's a tie...");
        }else{
            System.out.println("You Lose :(");
        }
    }
}