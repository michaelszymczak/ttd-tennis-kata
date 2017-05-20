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
    "RRSR"   | "15-40"
    "RRSS"   | "30-30"
    "RRSSS"  | "40-30"
  }

  def "should be a deuce if both players have 40 points"() {
    expect:
    resultAfter(sequence) == "deuce"

    where:
    sequence << [
            "SSSRRR",
            "RRRSSS"
    ]
  }


  def "should win if scored 4 times"() {
    expect:
    resultAfter(winningSequence) == expectedResult

    where:
    winningSequence | expectedResult
    "SSSS"          | "Serving player victory"
    "RSSSS"         | "Serving player victory"
    "RRSSSS"        | "Serving player victory"
    "RRRR"          | "Receiving player victory"
    "SRRRR"         | "Receiving player victory"
    "SSRRRR"        | "Receiving player victory"
  }

  def "should be an advantage if one score after deuce"() {
    expect:
    resultAfter(sequence) == expectedResult

    where:
    sequence       | expectedResult
    "SSSRRR" + "S" | "Advantage for serving player"
    "SSSRRR" + "R" | "Advantage for receiving player"
  }

  def "should be deuce if equalised after advantage"() {
    expect:
    resultAfter(sequence) == expectedResult

    where:
    sequence                   | expectedResult
    "SSSRRR" + "S" + "R"       | "deuce"
    "SSSRRR" + "R" + "S"       | "deuce"
    "SSSRRR" + "R" + "S" + "R" | "Advantage for receiving player"
    "SSSRRR" + "S" + "R" + "S" | "Advantage for serving player"
  }

  def "should win after advantage"() {
    expect:
    resultAfter(sequence) == expectedResult

    where:
    sequence             | expectedResult
    "SSSRRR" + "R" + "R" | "Receiving player victory"
    "SSSRRR" + "S" + "S" | "Serving player victory"
  }


  def "should do nothing after a victory"() {
    expect:
    resultAfter(sequence) == expectedResult

    where:
    sequence     | expectedResult
    "RRRR" + "R" | "Receiving player victory"
    "RRRR" + "S" | "Receiving player victory"
    "SSSS" + "S" | "Serving player victory"
    "SSSS" + "R" | "Serving player victory"
  }
}
