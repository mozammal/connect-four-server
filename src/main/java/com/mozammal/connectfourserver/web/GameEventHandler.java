package com.mozammal.connectfourserver.web;

import com.mozammal.connectfourserver.model.GameBoard;
import com.mozammal.connectfourserver.tictactoe.Connect4GameEngine;
import org.springframework.stereotype.Component;

@Component
public class GameEventHandler {

  public GameBoard findNextMoveByComputer(GameBoard gameBoard) {
    Connect4GameEngine connect4GameEngine = new Connect4GameEngine();
    GameBoard nextGameBoard = connect4GameEngine.TicTacToePlayedByComputer(gameBoard);
    return nextGameBoard;
  }
}
