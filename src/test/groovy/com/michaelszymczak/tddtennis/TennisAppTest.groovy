package com.michaelszymczak.tddtennis

import spock.lang.Specification

import static com.michaelszymczak.tddtennis.Play.resultAfter
import static com.michaelszymczak.tddtennis.TennisApp.startGame

class TennisAppTest extends Specification {

  def "no player should have any points upo starting the game"() {
    expect:
    startGame().result() == "love"
  }

  def "a player should have 15 points after first win"() {
    expect:
    resultAfter("S") == "15-love"
    resultAfter("R") == "love-15"
  }

  def "a player should have 30 points after second win"() {
    expect:
    resultAfter("SS") == "30-love"
  }

  def "should have appropriate number of points after scoring"() {
    expect:
    resultAfter(sequence) == expectedResult

    where:
    sequence | expectedResult
    "SSS"    | "40-love"
    "SSR"    | "30-15"
    "SSRS"   | "40-15"
    "SR"     | "15-15"
    "RS"     | "15-15"
  }
}
