/*
package com.mozammal.connectfourserver.tictactoe;

import com.mozammal.connectfourserver.model.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Connect4UtilityFunction implements GameUtilityFunction {
  private TreeNode treeNode;

  public Connect4UtilityFunction(TreeNode treeNode) {
    this.treeNode = treeNode;
  }

  @Override
  public int score() {
    int score = scoreEvaluatorForXOrO('O');
    if (score == 2) {
      return EvalStateConnect4.WIN.getCurrentEvalPoint();
    }
    score = scoreEvaluatorForXOrO('X');
    if (score == 2) {
      return EvalStateConnect4.LOSE.getCurrentEvalPoint();
    } else if (score == 0) {
      return EvalStateConnect4.ONGOING.getCurrentEvalPoint();
    } else {
      return EvalStateConnect4.DRAW.getCurrentEvalPoint();
    }
  }

  private int scoreEvaluatorForXOrO(Character c) {
    int cntDiagonalLeftToRight = 0, cntDiagonalRightToLeft = 0, cntEmptyCell = 0;
    Character[][] boards = treeNode.getBoards();
    int boardHeight = boards.length;
    int boardWidth = boards[0].length;

    int cntRow;
    int cntColumn;
    int cntDiagonal;

    for (int i = 0; i < boardWidth; i++) {
      int j = boardHeight - 1;
      cntRow = 0;
      for (; j >= 0 && boards[j][i] != null; j--) ;

      for (int k = boardHeight - 1; k > j; k--) {
        if (boards[k][i].equals(c)) {
          cntRow++;
          if (cntRow == 4) {
            return 2;
          }
        } else if (!boards[k][i].equals(c)) {
          cntRow = 0;
        }
      }
    }

    for (int i = 0; i < boardHeight; i++) {
      cntColumn = 0;

      for (int j = 0; j < boardWidth; j++) {
        if (boards[i][j] == null || !boards[i][j].equals(c)) {
          cntColumn = 0;
        } else if (boards[i][j].equals(c)) {
          cntColumn++;
          if (cntColumn == 4) {

            return 2;
          }
        }
      }
    }

    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        cntDiagonal = 0;
        boolean canContinue = true;
        if (boards[i][j] == null) continue;

        for (int k = i, l = j; k < boardHeight && l < boardWidth; k++, l++) {
          if (boards[k][l] == null || !boards[k][l].equals(c)) {
            cntDiagonal = 0;
          } else cntDiagonal++;
          if (cntDiagonal == 4) {

            // log.info("yes0 ");
            return 2;
          }
        }
      }
    }

    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        cntDiagonal = 0;
        if (boards[i][j] == null) continue;
        for (int k = i, l = j; k < boardHeight && l >= 0; k++, l--) {
          if (boards[k][l] == null || !boards[k][l].equals(c)) {
            cntDiagonal = 0;
          } else cntDiagonal++;
          if (cntDiagonal == 4) {

            return 2;
          }
        }
      }
    }

    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        cntDiagonal = 0;
        boolean canContinue = true;
        if (boards[i][j] == null) continue;
        for (int k = i, l = j; k >= 0 && l < boardHeight; k--, l++) {
          if (boards[k][l] == null || !boards[k][l].equals(c)) {
            cntDiagonal = 0;
          } else cntDiagonal++;
          if (cntDiagonal == 4) {
            // log.info("yes2 ");
            */
/*  Board board = new Board();
            board.setBoard(boards);
            board.printBoard();
            log.info("yes2 ");*//*

            return 2;
          }
        }
      }
    }

    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        cntDiagonal = 0;
        if (boards[i][j] == null) continue;
        for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
          if (boards[k][l] == null || !boards[k][l].equals(c)) {
            cntDiagonal = 0;
          } else cntDiagonal++;
          if (cntDiagonal == 4) {
            // log.info("yes3 ");
            return 2;
          }
        }
      }
    }

    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        if (boards[i][j] == null) {
          cntEmptyCell++;
        }
      }
    }
    */
/*  if (cntEmptyCell > 0) {
      log.info("mon0 ");
      Board board = new Board();
      board.setBoard(boards);
      board.printBoard();
    }*//*


    return cntEmptyCell > 0 ? 0 : 1;
  }
}
*/
