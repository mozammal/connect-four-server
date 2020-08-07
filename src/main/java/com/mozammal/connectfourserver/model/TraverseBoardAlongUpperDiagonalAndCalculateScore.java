package com.mozammal.connectfourserver.model;

public class TraverseBoardAlongUpperDiagonalAndCalculateScore implements CalculateScore {

  @Override
  public ScoreTuple calculateScore(GameBoard gameBoard, Character ch) {
    int cntDiagonal;
    int two = 0;
    int three = 0;
    int four = 0;
    Character[][] boards = gameBoard.getBoard();

    for (int i = 0; i < boards.length; i++) {
      for (int j = 0; j < boards[0].length; j++) {
        cntDiagonal = 0;
        if (boards[i][j] == null) continue;

        for (int k = i, l = j; k < boards.length && l < boards[0].length; k++, l++) {
          if (cntDiagonal == 2) {
            two++;
          } else if (cntDiagonal == 3) {
            three++;
          } else if (cntDiagonal == 4) {
            four++;
          }
          if (boards[k][l] == null || !boards[k][l].equals(ch)) {
            cntDiagonal = 0;
          } else {
            cntDiagonal++;
          }

        }
      }
    }
    return ScoreTuple.builder().numberOfTwo(two).numberOfThree(three).numberOfFour(four).build();
  }
}
