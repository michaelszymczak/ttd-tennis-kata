package com.michaelszymczak.tddtennis;

public enum Result {

  LOVE("love", "_15_LOVE", "LOVE_15"),
  _15_LOVE("15-love", "_30_LOVE", "_15_15"),
  _30_LOVE("30-love", "_40_LOVE", "_30_15"),
  _40_LOVE("40-love", "SERVING_PLAYER_VICTORY", "_40_15"),
  LOVE_15("love-15", "_15_15", "LOVE_30"),
  _15_15("15-15", "_30_15", "_15_30"),
  _30_15("30-15", "_40_15", "_30_30"),
  _40_15("40-15", "SERVING_PLAYER_VICTORY", "_40_30"),
  LOVE_30("love-30", "_15_30", "LOVE_40"),
  _15_30("15-30", "_30_30", "_15_40"),
  _30_30("30-30", "_40_30", "_30_40"),
  _40_30("40-30", "SERVING_PLAYER_VICTORY", "DEUCE"),
  _30_40("30-40", "DEUCE", "RECEIVING_PLAYER_VICTORY"),
  LOVE_40("love-40", "_15_40", "RECEIVING_PLAYER_VICTORY"),
  _15_40("15-40", "_30_40", "RECEIVING_PLAYER_VICTORY"),
  DEUCE("deuce", "ADVANTAGE_SERVING_PLAYER", "ADVANTAGE_RECEIVING_PLAYER"),
  SERVING_PLAYER_VICTORY("Serving player victory", "T", "U"),
  RECEIVING_PLAYER_VICTORY("Receiving player victory", "W", "X"),
  ADVANTAGE_SERVING_PLAYER("Advantage for serving player", "-1", "DEUCE"),
  ADVANTAGE_RECEIVING_PLAYER("Advantage for receiving player", "DEUCE", "-4");

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
