package com.michaelszymczak.tddtennis;

public enum Result {

  LOVE("love"),
  _15_LOVE("15-love"),
  LOVE_15("love-15");

  private final String score;

  Result(String score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return score;
  }
}
