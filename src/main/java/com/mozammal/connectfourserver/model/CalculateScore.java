package com.mozammal.connectfourserver.model;

public interface CalculateScore {

    public ScoreTuple calculateScore(GameBoard gameBoard, Character ch);
}
