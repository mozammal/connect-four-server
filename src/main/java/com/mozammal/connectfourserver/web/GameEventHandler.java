package com.mozammal.connectfourserver.web;

import com.mozammal.connectfourserver.model.Board;
import com.mozammal.connectfourserver.tictactoe.Connect4GameEngine;
import org.springframework.stereotype.Component;

@Component
public class GameEventHandler {

  public Board findNextMoveByComputer(Board board) {
    Connect4GameEngine connect4GameEngine = new Connect4GameEngine();
    Board nextBoard = connect4GameEngine.TicTacToePlayedByComputer(board);
    return nextBoard;
  }
}
