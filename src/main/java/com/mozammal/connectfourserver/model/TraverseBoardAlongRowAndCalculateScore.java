package com.mozammal.connectfourserver.model;

public class TraverseBoardAlongRowAndCalculateScore implements CalculateScore {

  @Override
  public ScoreTuple calculateScore(GameBoard gameBoard, Character ch) {
    int cntColumn;
    int two = 0;
    int three = 0;
    int four = 0;
    Character[][] boards = gameBoard.getBoard();

    for (int i = 0; i < boards.length; i++) {
      cntColumn = 0;

      for (int j = 0; j < boards[0].length; j++) {
        if (boards[i][j] == null || !boards[i][j].equals(ch)) {
          cntColumn = 0;
        } else if (boards[i][j].equals(ch)) {
          cntColumn++;
        }
        if (cntColumn == 2) two++;
        if (cntColumn == 3) three++;
        if (cntColumn == 4) four++;
      }
    }
    return ScoreTuple.builder().
            numberOfTwo(two).
            numberOfThree(three).
            numberOfFour(four).build();
  }
}
