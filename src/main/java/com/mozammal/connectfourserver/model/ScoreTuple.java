package com.mozammal.connectfourserver.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ScoreTuple {

  private int numberOfTwo;

  private int numberOfThree;

  private int numberOfFour;

  public ScoreTuple add(ScoreTuple that) {
    return ScoreTuple.builder()
            .numberOfTwo(this.numberOfTwo+that.numberOfTwo)
            .numberOfThree(this.numberOfThree + that.numberOfThree)
            .numberOfFour(this.numberOfFour + that.numberOfFour)
            .build();
  }
}
