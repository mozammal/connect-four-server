package com.mozammal.connectfourserver.tictactoe;

import lombok.Data;

@Data
public class TreeNode {
  private Character[][] boards;
  private final int boardHeight;
  private final int boardWidth;

  public TreeNode(int boardHeight, int boardWidth) {
    boards = new Character[boardHeight][boardHeight];
    this.boardHeight = boardHeight;
    this.boardWidth = boardWidth;
  }

  public Character[][] copy() {
    Character[][] ch = new Character[boardHeight][boardWidth];
    for (int i = 0; i < boardHeight; i++)
      for (int j = 0; j < boardWidth; j++) ch[i][j] = boards[i][j];

    return ch;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) sb.append(boards[i][j]).append(" ");
      sb.append("\n");
    }
    return sb.toString();
  }
}
