package com.michaelszymczak.tddtennis;

public enum Result {

  LOVE("love", "_15_LOVE", "LOVE_15"),
  _15_LOVE("15-love", "_30_LOVE", ""),
  _30_LOVE("30-love", "", ""),
  LOVE_15("love-15", "", "");

  private final String score;
  private String scoreIfServingPlayerScores;
  private String scoreIfReceivingPlayerScores;

  Result(String score, String scoreIfServingPlayerScores, String scoreIfReceivingPlayerScores) {
    this.score = score;
    this.scoreIfServingPlayerScores = scoreIfServingPlayerScores;
    this.scoreIfReceivingPlayerScores = scoreIfReceivingPlayerScores;
  }

  @Override
  public String toString() {
    return score;
  }

  public Result afterServingScored() {
    return Result.valueOf(scoreIfServingPlayerScores);
  }

  public Result afterReceivingScored() {
    return Result.valueOf(scoreIfReceivingPlayerScores);
  }
}
