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

  def "should have appropriate number of points after scoring"() {
    expect:
    startGame().servingPlayerScores().servingPlayerScores().servingPlayerScores().result() == "40-love"
    startGame().servingPlayerScores().servingPlayerScores().receivingPlayerScores().result() == "30-15"
    startGame().servingPlayerScores().servingPlayerScores().receivingPlayerScores().servingPlayerScores().result() == "40-15"
    startGame().servingPlayerScores().receivingPlayerScores().result() == "15-15"
    startGame().receivingPlayerScores().servingPlayerScores().result() == "15-15"

  }
}
