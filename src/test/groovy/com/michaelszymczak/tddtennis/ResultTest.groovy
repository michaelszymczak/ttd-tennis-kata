package com.michaelszymczak.tddtennis

import spock.lang.Specification

class ResultTest extends Specification {
  def "should return appropriate string"() {
    expect:
    Result.LOVE.toString() == "love"
    Result._15_LOVE.toString() == "15-love"

  }
}
