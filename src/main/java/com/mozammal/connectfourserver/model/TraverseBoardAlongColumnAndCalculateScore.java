package com.mozammal.connectfourserver.model;

public class TraverseBoardAlongColumnAndCalculateScore implements CalculateScore {

  @Override
  public ScoreTuple calculateScore(GameBoard gameBoard, Character ch) {
    int cntRow;
    int two = 0;
    int three = 0;
    int four = 0;
    Character[][] boards = gameBoard.getBoard();

    for (int i = 0; i < boards[0].length; i++) {
      int j = boards.length - 1;
      cntRow = 0;
      for (; j >= 0 && boards[j][i] != null; j--) ;

      for (int k = boards.length - 1; k > j; k--) {
        if (boards[k][i].equals(ch)) {
          cntRow++;

        } else if (!boards[k][i].equals(ch)) {
          cntRow = 0;
        }
        if (cntRow == 2) two++;
        if (cntRow == 3) three++;
        if (cntRow == 4) four++;
      }
    }
    return ScoreTuple.builder().
            numberOfTwo(two).
            numberOfThree(three).
            numberOfFour(four).
            build();
  }
}
