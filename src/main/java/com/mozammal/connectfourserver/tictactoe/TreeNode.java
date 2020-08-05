package com.mozammal.connectfourserver.tictactoe;

import com.mozammal.connectfourserver.model.GameBoard;
import lombok.Data;

@Data
public class TreeNode {
  private GameBoard gameBoard;
  private final int boardHeight;
  private final int boardWidth;

  public TreeNode(int boardHeight, int boardWidth) {
    this.boardHeight = boardHeight;
    this.boardWidth = boardWidth;
  }
}
