package com.michaelszymczak.tddtennis

class Play {
  static String resultAfter(String sequence) {

    def tennisApp = TennisApp.startGame()
    sequence.chars().forEach {
      (((char) it) == (char) 'S') ? tennisApp.servingPlayerScores() : tennisApp.receivingPlayerScores()
    }

    tennisApp.result()
  }
}
