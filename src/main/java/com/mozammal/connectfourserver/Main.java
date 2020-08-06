
package com.mozammal.connectfourserver;

import com.mozammal.connectfourserver.model.GameBoard;
import com.mozammal.connectfourserver.connect4.Connect4UtilityFunction;
import com.mozammal.connectfourserver.connect4.TreeNode;
import com.mozammal.connectfourserver.web.GameEventHandler;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    GameEventHandler gameEventHandler = new GameEventHandler();
    GameBoard gameBoard = new GameBoard();

    Scanner in = new Scanner(System.in);

    while (true) {
      Character[][] boards = gameBoard.getBoard();
      int col = in.nextInt();
      for (int i = 5; i >= 0; i--) {
        if (boards[i][col] == null) {
          boards[i][col] = 'X';
          break;
        }
      }
      System.out.println("GameBoard after your input: ");
      gameBoard.printBoard();

      gameBoard = gameEventHandler.findNextMoveByComputer(gameBoard);
      TreeNode treeNode = new TreeNode(6, 7);
      treeNode.setGameBoard(gameBoard);
      Connect4UtilityFunction gameUtilityFunction = new Connect4UtilityFunction(treeNode);
      int currentScore = gameUtilityFunction.score();
      System.out.println("GameBoard after computer moved: ");
      gameBoard.printBoard();
      if (currentScore == -2) {
        System.out.println("LOSE");
        break;
      } else if (currentScore == 2) {
        System.out.println("WIN");
        break;
      } else if (currentScore == 1) {
        System.out.println("DRAW");
        break;
      }
    }
  }
}
