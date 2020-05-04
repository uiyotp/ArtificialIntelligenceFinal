public class MiniMax{
    public static Move MiniMax(State state, Player player, double alpha, double beta){
        Move bestMove = new Move();
        Move currentMove = new Move();
        double bestVal;
        if(state.isTerminal()){
            bestMove = new Move(null, state.evaluate( player ));
            return bestMove;
        }       
        if( state.getCurrentPlayer() == player ){
            bestVal = Double.MIN_VALUE;
            int[][] possibleMoves = state.getMoves();
            for(int i = 0; i<possibleMoves.length; i++){
                State newState = deepCopyState(state);
                newState.makeMove( possibleMoves[i] );
                currentMove = MiniMax( newState , player, alpha, beta);
                if(bestVal<=currentMove.getScore()){
                    bestMove.setScore(currentMove.getScore());
                    bestMove.setPlay(possibleMoves[i]);
                    bestVal = currentMove.getScore();
                }
                if(alpha<bestVal){
                    alpha = bestVal;
                }
                if(beta <= alpha){
                    break;
                }
            }
            return bestMove;
        }
        else{
            bestVal = Double.MAX_VALUE;
            int[][] possibleMoves = state.getMoves();
            for(int i = 0; i<possibleMoves.length; i++){
                State newState = deepCopyState(state);
                newState.makeMove( possibleMoves[i] );
                currentMove = MiniMax( newState , player, alpha, beta);
                if(bestVal>=currentMove.getScore()){
                    bestMove.setScore(currentMove.getScore());
                    bestMove.setPlay(possibleMoves[i]);
                    bestVal = currentMove.getScore();
                }
                if(beta>bestVal){
                    beta = bestVal;
                }
                if(beta <= alpha){
                    break;
                }
            }
            return bestMove;
        }

        // for(int i = 0; i<possibleMoves.length; i++){
        // State newState = deepCopyState(state);
        // newState.makeMove( possibleMoves[i] );
        // currentMove = MiniMax( newState , player, maxDepth , currentDepth + 1 );

        // if( state.getCurrentPlayer() == player ){
        // if(currentMove.getScore() > bestMove.getScore() ){
        // bestMove.setScore(currentMove.getScore());
        // bestMove.setPlay(possibleMoves[i]);
        // }
        // }
        // else{
        // if(currentMove.getScore() < bestMove.getScore() ){
        // bestMove.setScore(currentMove.getScore());
        // bestMove.setPlay(possibleMoves[i]);
        // }
        // }
        // }
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