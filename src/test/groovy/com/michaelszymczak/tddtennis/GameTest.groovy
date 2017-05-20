package com.michaelszymczak.tddtennis

import spock.lang.Specification

import static com.michaelszymczak.tddtennis.Game.startedGame
import static com.michaelszymczak.tddtennis.Result.LOVE
import static com.michaelszymczak.tddtennis.Result._15_LOVE

class GameTest extends Specification {

  def "should have score as love before any points scored"() {
    expect:
    startedGame().result() == LOVE

  }
  def "should change result from love to 15-love if the serving player scores"() {
    expect:
    startedGame().servingPlayerScores().result() == _15_LOVE
  }
}
