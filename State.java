import java.lang.reflect.Array;
public class State{
    private int[][] board = new int[5][];
    private Player[][] boxes = new Player[2][2];
    private Player currentPlayer;
    private Player[] players = new Player[2];
    public State(){
        int[][] board = {
                {0,0},
                {0,0,0},
                {0,0},
                {0,0,0},
                {0,0}
            };
        this.board = board;
        this.boxes = boxes;
        Player user = new Player("user");
        Player computer = new Player("computer");
        Player[] players = {user,computer};
        this.players = players;
        currentPlayer = players[0];
    }

    public State(int[][] board, Player[][] boxes, Player[] players, Player currentPlayer){
        this.board = board;
        this.boxes = boxes;
        this.players = players;
        this.currentPlayer = currentPlayer;
    }

    public int[][] getMoves(){
        int[][] moves = new int[12][];
        int[] initial = {-1,-1};
        for(int i =0;i<12;i++){
            moves[i]=initial;
        }
        int moveCount = 0;
        for(int i=0;i<5;i++){
            if(i%2==0){
                for(int j=0;j<2;j++){
                    if(board[i][j]==0){
                        int[] move = {i,j};
                        moves[moveCount++]=move;
                    }
                }
            }else{
                for(int j=0;j<3;j++){
                    if(board[i][j]==0){
                        int[] move = {i,j};
                        moves[moveCount++]=move;
                    }
                }
            }

        }
        return moves;
    }

    public State clone(){
        State newState = new State(board,boxes,players,currentPlayer);
        return newState;
    }

    public int evaluate(Player player){
        int boxCount=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                if(boxes[i][j] == player){
                    boxCount++;
                }
            }
        }
        return boxCount;
    }

    public void makeMove(int[] move){
        if(board[move[0]][move[1]]==0){
            board[move[0]][move[1]]++;
            if(!checkBoxes()){
                if(currentPlayer==players[0]){
                    currentPlayer=players[1];
                }else{
                    currentPlayer=players[0];
                }
            }
        }else{
            System.out.println("NOT A VALID MOVE!!!");
        }
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean isTerminal(){
        int[][] moves = getMoves();
        if(moves[0][0]==-1){
            return true;
        }
        return false;
    }

    public Player getWinner(){
        if(evaluate(players[0])>evaluate(players[1])){
            return players[0];
        }
        if(evaluate(players[0])<evaluate(players[1])){
            return players[1];
        }else{
            return null;
        }
    }

    public boolean checkBoxes(){
        boolean newBox = false;
        if(board[0][0]==1&&board[1][0]==1&&board[1][1]==1&&board[2][0]==1){
            if(boxes[0][0]==null){
                boxes[0][0]=currentPlayer;
                newBox=true;
            }
        }
        if(board[1][1]==1&&board[0][1]==1&&board[2][1]==1&&board[1][2]==1){
            if(boxes[0][1]==null){
                boxes[0][1]=currentPlayer;
                newBox=true;
            }
        }
        if(board[2][0]==1&&board[3][0]==1&&board[4][0]==1&&board[3][1]==1){
            if(boxes[1][0]==null){
                boxes[1][0]=currentPlayer;
                newBox=true;
            }
        }
        if(board[3][1]==1&&board[2][1]==1&&board[4][1]==1&&board[3][2]==1){
            if(boxes[1][1]==null){
                boxes[1][1]=currentPlayer;
                newBox=true;
            }
        }
        return newBox;
    }
}
