package com.michaelszymczak.tddtennis

import spock.lang.Specification

import static com.michaelszymczak.tddtennis.Play.resultAfter
import static com.michaelszymczak.tddtennis.TennisApp.startGame

class TennisAppTest extends Specification {

  def "no player should have any points upo starting the game"() {
    expect:
    startGame().result() == "love"
  }

  def "a serving player should have 15 points after first win"() {
    expect:
    resultAfter("S") == "15-love"
  }

  def "a receiving player should have 15 points"() {
    expect:
    resultAfter("R") == "love-15"
  }

  def "should have appropriate number of points after scoring"() {
    expect:
    resultAfter(sequence) == expectedResult

    where:
    sequence | expectedResult
    ""       | "love"
    "S"      | "15-love"
    "SS"     | "30-love"
    "SSS"    | "40-love"
    "SSSR"   | "40-15"
    "SSSRR"  | "40-30"
    "SSSRR"  | "40-30"
    "SSR"    | "30-15"
    "SSRR"   | "30-30"
    "SSRRR"  | "30-40"
    "R"      | "love-15"
    "RR"     | "love-30"
    "RRR"    | "love-40"
    "RRRS"   | "15-40"
    "RRRSS"  | "30-40"
  }
}
