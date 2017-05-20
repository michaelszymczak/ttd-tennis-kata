package com.michaelszymczak.tddtennis

import spock.lang.Specification

class PlayTest extends Specification {
  def "should start game"() {
    Play.resultAfter("") == TennisApp.startGame().result()
  }

  def "should score as serving if S"() {
    expect:
    Play.resultAfter("S") == TennisApp.startGame().servingPlayerScores().result()
    Play.resultAfter("SSS") == TennisApp.startGame().servingPlayerScores().servingPlayerScores().servingPlayerScores().result()
  }

  def "should score as receiving if R"() {
    expect:
    Play.resultAfter("R") == TennisApp.startGame().receivingPlayerScores().result()
    Play.resultAfter("RR") == TennisApp.startGame().receivingPlayerScores().receivingPlayerScores().result()
  }

  def "should score as appropriate player"() {
    expect:
    Play.resultAfter("RSS") == TennisApp.startGame().receivingPlayerScores().servingPlayerScores().servingPlayerScores().result()
    Play.resultAfter("RRS") == TennisApp.startGame().receivingPlayerScores().receivingPlayerScores().servingPlayerScores().result()
  }
}
