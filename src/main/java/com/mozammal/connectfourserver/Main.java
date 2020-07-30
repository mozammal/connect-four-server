/*
package com.mozammal.connectfourserver;

import com.mozammal.connectfourserver.model.Board;
import com.mozammal.connectfourserver.tictactoe.Connect4UtilityFunction;
import com.mozammal.connectfourserver.tictactoe.TreeNode;
import com.mozammal.connectfourserver.web.GameEventHandler;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    GameEventHandler gameEventHandler = new GameEventHandler();
    Board board = new Board();
    Character[][] boards = board.getBoard();
    Scanner in = new Scanner(System.in);

    while (true) {
      int col = in.nextInt();
      for (int i = 5; i >= 0; i--) {
        if (boards[i][col] == null) {
          boards[i][col] = 'X';
          break;
        }
      }
      System.out.println("Board after your input: ");
      board.printBoard();

      boards = gameEventHandler.findNextMoveByComputer(board).copy();
      board.setBoard(boards);
      TreeNode treeNode = new TreeNode(6, 7);
      treeNode.setBoards(boards);
      Connect4UtilityFunction gameUtilityFunction = new Connect4UtilityFunction(treeNode);
      int currentScore = gameUtilityFunction.score();
      System.out.println("Board after computer moved: ");
      board.printBoard();
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
*/
