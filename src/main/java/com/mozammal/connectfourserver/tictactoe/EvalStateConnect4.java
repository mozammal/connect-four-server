package com.mozammal.connectfourserver.tictactoe;

public enum EvalStateConnect4 {
  LOSE(-2),
  WIN(2),
  DRAW(1),
  ONGOING(0);
  private int currentEvalPoint;

  EvalStateConnect4(int currentEvalPoint) {
    this.currentEvalPoint = currentEvalPoint;
  }
  public int getCurrentEvalPoint() {
    return currentEvalPoint;
  }
}
