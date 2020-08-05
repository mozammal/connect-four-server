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
    int scoreByComputer = scoreEvaluatorForXOrO('O');
    int scoreByHuman = scoreEvaluatorForXOrO('X');
    if (scoreByHuman >= 10000000)
      return -100000000;

    // if (scoreByHuman == Integer.MAX_VALUE) return Integer.MIN_VALUE;
    // if (scoreByComputer == Integer.MAX_VALUE) return Integer.MIN_VALUE;

    return scoreByComputer - scoreByHuman;

    // Character[][] boards = treeNode.getBoards();

    /* int cntEmptyCell = 0;
    for (int i = 0; i < boards.length; i++) {
      for (int j = 0; j < boards[0].length; j++) {
        if (boards[i][j] == null) {
          cntEmptyCell++;
        }
      }
    }
    return cntEmptyCell > 0 ? 0 : 1;*/

    /*  if (score == 2) {
      return EvalStateConnect4.LOSE.getCurrentEvalPoint();
    } else if (score == 0) {
      return EvalStateConnect4.ONGOING.getCurrentEvalPoint();
    } else {
      return EvalStateConnect4.DRAW.getCurrentEvalPoint();
    }*/
  }

  int checkVertical(Character[][] board, Character ch) {
    // Check only if row is 3 or greater
    for (int r = 3; r < 6; r++) {
      for (int c = 0; c < 7; c++) {
        if (board[r][c] != null && board[r][c] == ch) {
          if (board[r][c] == board[r - 1][c]
              && board[r][c] == board[r - 2][c]
              && board[r][c] == board[r - 3][c]) {
            return 2;
          }
        }
      }
    }
    return 0;
  }

  int checkHorizontal(Character[][] board, Character ch) {
    // Check only if column is 3 or less
    for (int r = 0; r < 6; r++) {
      for (int c = 0; c < 4; c++) {
        if (board[r][c] != null && board[r][c] == ch) {
          if (board[r][c] == board[r][c + 1]
              && board[r][c] == board[r][c + 2]
              && board[r][c] == board[r][c + 3]) {
            return board[r][c];
          }
        }
      }
    }
    return 0;
  }

  int checkDiagonalRight(Character[][] board, Character ch) {
    // Check only if row is 3 or greater AND column is 3 or less
    for (int r = 3; r < 6; r++) {
      for (int c = 0; c < 4; c++) {
        if (board[r][c] != null && board[r][c] == ch) {
          if (board[r][c] == board[r - 1][c + 1]
              && board[r][c] == board[r - 2][c + 2]
              && board[r][c] == board[r - 3][c + 3]) {
            return 2;
          }
        }
      }
    }
    return 0;
  }

  int checkDiagonalLeft(Character[][] board, Character ch) {
    // Check only if row is 3 or greater AND column is 3 or greater
    for (int r = 3; r < 6; r++) {
      for (int c = 3; c < 7; c++) {
        if (board[r][c] != null && board[r][c] == ch) {
          if (board[r][c] == board[r - 1][c - 1]
              && board[r][c] == board[r - 2][c - 2]
              && board[r][c] == board[r - 3][c - 3]) {
            return board[r][c];
          }
        }
      }
    }
    return 0;
  }

  int checkDraw(Character[][] board, Character ch) {
    for (int r = 0; r < 6; r++) {
      for (int c = 0; c < 7; c++) {
        if (board[r][c] != null) {
          return 0;
        }
      }
    }
    return 1;
  }

  int checkAll(Character[][] board, Character ch) {
    if (this.checkVertical(board, ch) > 1
        || this.checkDiagonalRight(board, ch) > 0
        || this.checkDiagonalLeft(board, ch) > 0
        || this.checkHorizontal(board, ch) > 0) return 2;
    return checkDraw(board, ch);
  }

  private int scoreEvaluatorForXOrO(Character c) {
    int cntDiagonalLeftToRight = 0, cntDiagonalRightToLeft = 0, cntEmptyCell = 0;
    Character[][] boards = treeNode.getBoards();
    int boardHeight = boards.length;
    int boardWidth = boards[0].length;

    int cntRow;
    int cntColumn;
    int cntDiagonal;
    int two = 0, three = 0, four = 0;

    for (int i = 0; i < boardWidth; i++) {
      int j = boardHeight - 1;
      cntRow = 0;
      for (; j >= 0 && boards[j][i] != null; j--) ;

      for (int k = boardHeight - 1; k > j; k--) {
        if (boards[k][i].equals(c)) {
          cntRow++;
          if (cntRow == 2) two++;
          if (cntRow == 3) three++;
          if (cntRow == 4) four++;

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
          if (cntColumn == 2) two++;
          if (cntColumn == 3) three++;
          if (cntColumn == 4) four++;
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

          if (cntDiagonal == 2) two++;
          if (cntDiagonal == 3) three++;
          if (cntDiagonal == 4) four++;
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
          if (cntDiagonal == 2) two++;
          if (cntDiagonal == 3) three++;
          if (cntDiagonal == 4) four++;
        }
      }
    }

    return two * 10 + three * 1000 + four * 10000000;

    /*for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        if (boards[i][j] == null) {
          cntEmptyCell++;
        }
      }
    }*/
    /*  if (cntEmptyCell > 0) {
      log.info("mon0 ");
      Board board = new Board();
      board.setBoard(boards);
      board.printBoard();
    }*/

    // return cntEmptyCell > 0 ? 0 : 1;
  }
}
