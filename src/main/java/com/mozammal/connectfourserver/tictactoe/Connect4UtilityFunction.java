package com.mozammal.connectfourserver.tictactoe;

import com.mozammal.connectfourserver.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.mozammal.connectfourserver.config.GameConfig.*;

@Slf4j
public class Connect4UtilityFunction implements GameUtilityFunction {
  private TreeNode treeNode;

  public Connect4UtilityFunction(TreeNode treeNode) {
    this.treeNode = treeNode;
  }

  @Override
  public int score() {
    int scoreByComputer = scoreEvaluatorForXOrO('O');
    int scoreByHuman = scoreEvaluatorForXOrO('X');
    if (scoreByHuman >= MAX_SCORE_THRESHOLD) {
      return MINIMUM_SCORE_THRESHOLD;
    } else if (scoreByComputer >= MAX_SCORE_THRESHOLD) {
      return MAX_SCORE_THRESHOLD;
    }
    return scoreByComputer - scoreByHuman;
  }

  private int scoreEvaluatorForXOrO(Character ch) {

    List<CalculateScore> scoreStrategy =
        Arrays.asList(
            new TraverseBoardAlongColumnAndCalculateScore(),
            new TraverseBoardAlongRowAndCalculateScore(),
            new TraverseBoardAlongLowerDiagonalAndCalculateScore(),
            new TraverseBoardAlongUpperDiagonalAndCalculateScore());

    List<ScoreTuple> scoreTuples =
        scoreStrategy.stream()
            .map(s -> s.calculateScore(treeNode.getGameBoard(), ch))
            .collect(Collectors.toList());
    ScoreTuple scoreTuple = scoreTuples.get(0);
    for (ScoreTuple tuple : scoreTuples.subList(1, scoreTuples.size())) {
      scoreTuple = scoreTuple.add(tuple);
    }

    return scoreTuple.getNumberOfTwo() * WEIGHT_FOR_CONSECUTIVE_TWO
        + scoreTuple.getNumberOfThree() * WEIGHT_FOR_CONSECUTIVE_THREE
        + scoreTuple.getNumberOfFour() * WEIGHT_FOR_CONSECUTIVE_FOUR;
  }
}
