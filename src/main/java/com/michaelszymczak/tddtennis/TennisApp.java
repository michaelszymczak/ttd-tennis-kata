package com.michaelszymczak.tddtennis;

public class TennisApp {

  public static void main(String[] args) {
    System.out.println("Hello TDD Tennis.");
  }

  public static TennisApp startGame() {
    return new TennisApp();
  }

  public String result() {
    return "love";
  }

}
