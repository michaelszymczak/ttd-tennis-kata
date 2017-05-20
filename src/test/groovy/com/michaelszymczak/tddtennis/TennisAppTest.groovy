package com.michaelszymczak.tddtennis

import spock.lang.Specification

import static com.michaelszymczak.tddtennis.TennisApp.startGame

class TennisAppTest extends Specification {

  def "no player should have any points upo starting the game"() {
    expect:
    startGame().result() == "love"
  }

  def "a player should have 15 points after first win"() {
    expect:
    startGame().servingPlayerScores().result() == "15-love"
    startGame().receivingPlayerScores().result() == "love-15"
  }

  def "a player should have 30 points after second win"() {
    expect:
    startGame().servingPlayerScores().servingPlayerScores().result() == "30-love"
  }
}
