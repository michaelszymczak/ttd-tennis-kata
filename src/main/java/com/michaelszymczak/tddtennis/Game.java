package com.michaelszymczak.tddtennis;

public class Game {

  private final Result result;

  public Game(Result result) {
    this.result = result;
  }

  public static Game startedGame() {
    return new Game(Result.LOVE);
  }

  public Result result() {
    return result;
  }

  public Game servingPlayerScores() {
    return new Game(Result._15_LOVE);
  }
}
