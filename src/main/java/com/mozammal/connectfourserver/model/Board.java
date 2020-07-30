package com.mozammal.connectfourserver.model;

import java.util.Arrays;

public class Board {
  private Character[][] board;

  public Board() {
    board = new Character[6][7];
  }

  public Character[][] copy() {
    Character[][] ch = new Character[6][7];
    for (int i = 0; i < 6; i++) for (int j = 0; j < 7; j++) ch[i][j] = board[i][j];

    return ch;
  }

  public Character[][] getBoard() {
    return board;
  }

  public void setBoard(Character[][] board) {
    this.board = board;
  }

  public void printBoard() {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        System.out.print(board[i][j] == null ? "." : board[i][j]);
      }
      System.out.println("");
    }
  }

  @Override
  public String toString() {
    return "Board{" + "board=" + Arrays.toString(board) + '}';
  }
}
