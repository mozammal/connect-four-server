package com.mozammal.connectfourserver.tictactoe;

import com.mozammal.connectfourserver.model.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Connect4GameEngine {
  private static final int BOARD_SIZE_ROW = 6;

  private static final int BOARD_SIZE_COLUMN = 7;
  private static Logger logger = LoggerFactory.getLogger(Connect4GameEngine.class);

  private enum TicTacToGameStateForComputer {
    WIN,
    DRAW
  }

  public Board TicTacToePlayedByComputer(Board board) {

    boolean isSolutionFound = false;
    TreeNode treeNode = new TreeNode(BOARD_SIZE_ROW, BOARD_SIZE_COLUMN);
    treeNode.setBoards(board.copy());
    Algorithm algorithm = new AlphaBetaAlgorithm(treeNode);
    Character[][] boardGeneratedByMAxScore = treeNode.copy();
    int maxScoreByComputer = Integer.MIN_VALUE;
    for (int i = 0; i < BOARD_SIZE_COLUMN; i++) {
      int j = BOARD_SIZE_ROW - 1;
      for (; j >= 0 && treeNode.getBoards()[j][i] != null; j--) ;
      if (j < 0) continue;

      if (treeNode.getBoards()[j][i] == null) {
        treeNode.getBoards()[j][i] = 'O';
        int scoreByComputer = algorithm.execute();
        if (maxScoreByComputer < scoreByComputer) {
          boardGeneratedByMAxScore = treeNode.copy();
          maxScoreByComputer = scoreByComputer;
         // if (maxScoreByComputer == 1) break;
          //  System.out.println("win: (" + j + "," + i + ")");
        }

        treeNode.getBoards()[j][i] = null;
      }
    }
    board.setBoard(boardGeneratedByMAxScore);
    // board.printBoard();
    return board;
  }
}
