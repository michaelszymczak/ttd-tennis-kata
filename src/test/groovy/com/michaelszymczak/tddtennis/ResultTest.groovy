package com.michaelszymczak.tddtennis

import spock.lang.Specification

import static com.michaelszymczak.tddtennis.Result.LOVE
import static com.michaelszymczak.tddtennis.Result.LOVE_15
import static com.michaelszymczak.tddtennis.Result._15_LOVE

class ResultTest extends Specification {
  def "should return appropriate string"() {
    expect:
    LOVE.toString() == "love"
    _15_LOVE.toString() == "15-love"
  }

  def "should know what is the next result if any of the players scores"() {
    expect:
    LOVE.afterServingScored() == _15_LOVE
    LOVE.afterReceivingScored() == LOVE_15

  }
}
