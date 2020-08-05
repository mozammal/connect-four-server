package com.mozammal.connectfourserver.model;

import lombok.Data;

import java.util.Arrays;

@Data
public class GameBoard {

  private static final int BOARD_HEIGHT = 6;

  private static final int BOARD_WIDTH = 7;

  private Character[][] board;

  public GameBoard() {
    board = new Character[BOARD_HEIGHT][BOARD_WIDTH];
  }

  public Character[][] copy() {
    Character[][] ch = new Character[BOARD_HEIGHT][BOARD_WIDTH];
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        ch[i][j] = board[i][j];
      }
    }

    return ch;
  }

  public void printBoard() {
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        System.out.print(board[i][j] == null ? "." : board[i][j]);
      }
      System.out.println("");
    }
  }

  @Override
  public String toString() {
    return "GameBoard{" + "gameBoard=" + Arrays.toString(board) + '}';
  }
}
