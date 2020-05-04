import java.util.Scanner;
import java.util.Random;
public class PlayGame{
    public static void main(String args[]){
        Random rand = new Random();
        int move;
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
        State currentState;
        boolean firstMove = true;
        System.out.println("Do you want to go first? (yes or no) NOTE: If you do not go first, then the game will be harder to win.");
        switch(input.nextLine()){
            case "yes":
            currentState = new State(board, boxes, players, user);
            break;
            default:
            currentState = new State(board, boxes, players, COM);
        }
        boolean practiceMode;
        System.out.println("Do you want to play in practice mode? (yes or no) NOTE: Practice mode shows you what the computer would do in your situation.");
        switch(input.nextLine()){
            case "yes":
            practiceMode = true;
            break;
            default:
            practiceMode = false;
        }
        while(!currentState.isTerminal()){
            int[][] getMoves = currentState.getMoves();
            switch(currentState.getCurrentPlayer().getName()){
                case "user":
                System.out.println("--------------------------------------------------");
                System.out.println(currentState);
                if(practiceMode){
                    if(firstMove){
                        //Ran the program with 12 depth and waited 5 minutes for the best move.  It was 4,1 and then I chose the three equivalent moves
                        //and added them to the possible moves array to speed up the program on the first iteration
                        int[][] possibleMoves = {{0,0},{1,2},{3,0},{4,1}};
                        move = rand.nextInt(possibleMoves.length);
                        Move recentMove = new Move(possibleMoves[move],0);
                        firstMove=false;
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
                firstMove=false;
                break;
                case "COM":
                if(currentState.getCurrentPlayer().getName().equals("COM")){
                    if(firstMove==true){
                        //Ran the program with 12 depth and waited 5 minutes for the best move.  It was 4,1 and then I chose the three equivalent moves
                        //and added them to the possible moves array to speed up the program on the first iteration
                        int[][] possibleMoves = {{0,0},{1,2},{3,0},{4,1}};
                        move = rand.nextInt(possibleMoves.length);
                        currentState.makeMove(possibleMoves[move]);
                        Move recentMove = new Move(possibleMoves[move],0);
                        System.out.println("The computer made the move: "+recentMove.toString());
                        firstMove=false;
                    }else if(getMoves.length<10){
                        Move bestMove = MiniMax.MiniMax(currentState, COM, Double.MIN_VALUE, Double.MAX_VALUE);
                        currentState.makeMove(bestMove.getPlay());
                        System.out.println("The computer made the move: "+bestMove.toString());
                    }else{
                        move = rand.nextInt(getMoves.length);
                        currentState.makeMove(getMoves[move]);
                        Move recentMove = new Move(getMoves[move],0);
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
}