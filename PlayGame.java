public class PlayGame{
    public static void main(String args[]){
        int[][] board = {
                {0,1},
                {0,1,1},
                {1,1},
                {0,1,0},
                {0,1}
            };
        Player user = new Player("user");
        Player COM = new Player("COM");
        Player[] players = {user,COM};
        Player[][] boxes = {{null,COM},{null,null}};
        State currentState = new State(board, boxes, players, COM);
        Move bestMove = MiniMax.MiniMax(currentState, COM, 5, 0);
        System.out.println(bestMove.toString());
    }
}