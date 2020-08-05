package com.mozammal.connectfourserver.web;

import com.mozammal.connectfourserver.config.Connect4;
import com.mozammal.connectfourserver.model.GameBoard;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GameWebController {
  Logger logger = LoggerFactory.getLogger(GameWebController.class);

  @Autowired GameEventHandler gameEventHandler;

  private SimpMessageSendingOperations template;
  private Connect4 properties;

  public GameWebController(SimpMessageSendingOperations template, Connect4 properties) {
    this.template = template;
    this.properties = properties;
  }

  @MessageMapping("/emit.game.event")
  public void findNextMoveByComputer(
          @Payload GameBoard gameBoard, @Header("simpSessionId") String sessionId) {
    GameBoard nextGameBoard = gameEventHandler.findNextMoveByComputer(gameBoard);
    this.template.convertAndSendToUser(
        sessionId, properties.getBroker() + "/game.event", nextGameBoard, createHeaders(sessionId));
  }

  private MessageHeaders createHeaders(String sessionId) {
    SimpMessageHeaderAccessor headerAccessor =
        SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
    headerAccessor.setSessionId(sessionId);
    headerAccessor.setLeaveMutable(true);
    return headerAccessor.getMessageHeaders();
  }
}
