package com.michaelszymczak.tddtennis;

public class TennisApp {

  private volatile Game game;

  public TennisApp() {
    this.game = Game.startedGame();
  }

  public static void main(String[] args) {
    System.out.println("Hello TDD Tennis.");
  }

  public static TennisApp startGame() {
    return new TennisApp();
  }

  public String result() {
    return game.result().toString();
  }

  public TennisApp servingPlayerScores() {
    this.game = game.servingPlayerScores();

    return this;
  }
}
