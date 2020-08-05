package com.mozammal.connectfourserver.tictactoe;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class AlphaBetaAlgorithm implements Algorithm {

  private static final Logger logger = LoggerFactory.getLogger(AlphaBetaAlgorithm.class);

  private TreeNode treeNode;
  private GameUtilityFunction gameUtilityFunction;

  public AlphaBetaAlgorithm(TreeNode treeNode) {
    this.treeNode = treeNode;
    this.gameUtilityFunction = new Connect4UtilityFunction(treeNode);
  }

  @Override
  public int execute() {

    return alphaBetaSearch(Integer.MIN_VALUE, Integer.MAX_VALUE, false, 10);
  }

  private int alphaBetaSearch(int alpha, int beta, boolean player, int depth) {

    int currentScore = gameUtilityFunction.score();

    if (depth == 0) return currentScore;
    Character[][] board = treeNode.getGameBoard().getBoard();

    for (int i = 0; i < 7; i++) {
      int j = 5;
      for (; j >= 0 && board[j][i] != null; j--) ;
      if (j < 0) continue;
      if (board[j][i] == null) {
        if (player) {
          board[j][i] = 'O';
        } else {
          board[j][i] = 'X';
        }
        if (player) {
          alpha = Math.max(alpha, alphaBetaSearch(alpha, beta, false, depth - 1));
        } else {
          beta = Math.min(beta, alphaBetaSearch(alpha, beta, true, depth - 1));
        }
        board[j][i] = null;
        if (player && alpha >= beta) return alpha;
        if (!player && beta <= alpha) return beta;
      }
    }

    return player ? alpha : beta;
  }
}
