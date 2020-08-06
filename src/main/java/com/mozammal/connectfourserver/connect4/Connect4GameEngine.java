package com.mozammal.connectfourserver.connect4;

import com.mozammal.connectfourserver.model.GameBoard;
import lombok.extern.slf4j.Slf4j;

import static com.mozammal.connectfourserver.config.GameConfig.MAX_SCORE_THRESHOLD;

@Slf4j
public class Connect4GameEngine {

  private static final int BOARD_SIZE_ROW = 6;

  private static final int BOARD_SIZE_COLUMN = 7;

  public GameBoard TicTacToePlayedByComputer(GameBoard gameBoard) {

    TreeNode treeNode = new TreeNode(BOARD_SIZE_ROW, BOARD_SIZE_COLUMN);
    treeNode.setGameBoard(gameBoard);
    Algorithm algorithm = new AlphaBetaAlgorithm(treeNode);
    Character[][] board = treeNode.getGameBoard().getBoard();
    Character[][] boardGeneratedByMAxScore = board;
    int maxScoreByComputer = Integer.MIN_VALUE;

    for (int i = 0; i < BOARD_SIZE_COLUMN; i++) {
      int j = BOARD_SIZE_ROW - 1;
      for (; j >= 0 && board[j][i] != null; j--) ;
      if (j < 0) continue;

      if (board[j][i] == null) {
        board[j][i] = 'O';
        int score = ((AlphaBetaAlgorithm) algorithm).getGameUtilityFunction().score();

        if (score == MAX_SCORE_THRESHOLD) {
          boardGeneratedByMAxScore = gameBoard.copy();
          board[j][i] = null;
          break;
        }

        int scoreByComputer = algorithm.execute();

        if (maxScoreByComputer < scoreByComputer) {
          boardGeneratedByMAxScore = gameBoard.copy();
          maxScoreByComputer = scoreByComputer;
        }

        board[j][i] = null;
      }
    }
    gameBoard.setBoard(boardGeneratedByMAxScore);
    return gameBoard;
  }
}
