package fr.sma.aoc.adventofcode2015.solution.day17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day17Ex1Test {

  @Test
  public void test1() {
    String input = """
      20
      15
      10
      5
      5""";

    int targetLiter = 25;

    String run = new Day17Ex1(targetLiter).run(input);
    assertEquals("4", run);
  }
}
