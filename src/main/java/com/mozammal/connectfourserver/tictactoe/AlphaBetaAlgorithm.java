package com.mozammal.connectfourserver.tictactoe;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

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
    List<Integer> triedDepths = Arrays.asList(1, 4, 8);
    int mxExpectation = Integer.MIN_VALUE;
    for (int depth : triedDepths)
      mxExpectation =
          Math.max(mxExpectation, alphaBetaSearch(Integer.MIN_VALUE, Integer.MAX_VALUE, false, depth));
    return mxExpectation;
  }

  private int alphaBetaSearch(int alpha, int beta, boolean player, int depth) {

    int currentScore = gameUtilityFunction.score();
    if (currentScore != 0) {
      return currentScore;
    }
    if (depth == 0) return currentScore;

    for (int i = 0; i < 7; i++) {
      int j = 5;
      for (; j >= 0 && treeNode.getBoards()[j][i] != null; j--) ;
      if (j < 0) continue;
      if (treeNode.getBoards()[j][i] == null) {
        if (player) treeNode.getBoards()[j][i] = 'O';
        else treeNode.getBoards()[j][i] = 'X';
        if (player) {
          alpha = Math.max(alpha, alphaBetaSearch(alpha, beta, false, depth - 1));
        } else {
          beta = Math.min(beta, alphaBetaSearch(alpha, beta, true, depth - 1));
        }
        treeNode.getBoards()[j][i] = null;
        if (player && alpha >= beta) return alpha;
        if (!player && beta <= alpha) return beta;
      }
    }

    return player ? alpha : beta;
  }
}
