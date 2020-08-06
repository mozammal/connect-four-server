package com.mozammal.connectfourserver.connect4;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.mozammal.connectfourserver.config.GameConfig.MAX_SCORE_THRESHOLD;
import static com.mozammal.connectfourserver.config.GameConfig.MINIMUM_SCORE_THRESHOLD;

@Slf4j
@Data
public class AlphaBetaAlgorithm implements Algorithm {

  private static final int SEARCH_DEPTH = 9;

  private TreeNode treeNode;

  private GameUtilityFunction gameUtilityFunction;

  public AlphaBetaAlgorithm(TreeNode treeNode) {
    this.treeNode = treeNode;
    this.gameUtilityFunction = new Connect4UtilityFunction(treeNode);
  }

  @Override
  public int execute() {
    List<Integer> depths = Arrays.asList(2, 8);
    OptionalInt max =
        depths.stream()
            .mapToInt(
                d -> alphaBetaSearch(Integer.MIN_VALUE, Integer.MAX_VALUE, false, SEARCH_DEPTH))
            .max();
    return max.getAsInt();
  }

  private int alphaBetaSearch(int alpha, int beta, boolean player, int depth) {

    int currentScore = gameUtilityFunction.score();
    if (currentScore == MAX_SCORE_THRESHOLD || currentScore == MINIMUM_SCORE_THRESHOLD)
      return currentScore;

    if (depth == 0) return currentScore;
    Character[][] board = treeNode.getGameBoard().getBoard();

    for (int i = 0; i < board[0].length; i++) {
      int j = board.length - 1;
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
