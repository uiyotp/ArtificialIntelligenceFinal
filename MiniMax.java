public class MiniMax{
    public static Move MiniMax(State state, Player player, int maxDepth, int currentDepth){
        Move bestMove = new Move();
        Move currentMove = new Move();
        if( state.isTerminal() || currentDepth == maxDepth ){
            System.out.println(state.toString());
            bestMove.setScore(state.evaluate( player ));
            bestMove.setPlay(null);
            return bestMove;
        }
        if( state.getCurrentPlayer() == player )
            bestMove.setScore(Double.MIN_VALUE);
        else
            bestMove.setScore(Double.MAX_VALUE);
        System.out.println(state.toString());
        int[][] possibleMoves = state.getMoves();
        for(int i = 0; i<possibleMoves.length; i++){
            State newState = deepCopyState(state);
            newState.makeMove( possibleMoves[i] );
            currentMove = MiniMax( newState , player, maxDepth , currentDepth + 1 );

            if( state.getCurrentPlayer() == player ){
                if(currentMove.getScore() > bestMove.getScore() ){
                    bestMove.setScore(currentMove.getScore());
                    bestMove.setPlay(possibleMoves[i]);
                }
            }
            else{
                if(currentMove.getScore() < bestMove.getScore() ){
                    bestMove.setScore(currentMove.getScore());
                    bestMove.setPlay(possibleMoves[i]);
                }
            }
        }

        return bestMove;
    }

    public static State deepCopyState(State state){
        State copiedState = new State();
        int[][] board = {
                {0,0},
                {0,0,0},
                {0,0},
                {0,0,0},
                {0,0}
            };
        Player[][] boxes = new Player[2][2];
        Player[] players = new Player[2];
        int[][] boardToCopy = state.getBoard();
        Player[][] boxesToCopy = state.getBoxes();
        for(int i=0;i<5;i++){
            if(i%2==0){
                for(int j=0;j<2;j++){
                    board[i][j]=boardToCopy[i][j];
                }
            }else{
                for(int j=0;j<3;j++){
                    board[i][j]=boardToCopy[i][j];
                }
            }

        }
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                boxes[i][j]=boxesToCopy[i][j];
            }
        }
        copiedState.setBoard( board );
        copiedState.setBoxes( boxes );
        copiedState.setPlayers( state.getPlayers() );
        copiedState.setCurrentPlayer( state.getCurrentPlayer() );
        return copiedState;
    }
}