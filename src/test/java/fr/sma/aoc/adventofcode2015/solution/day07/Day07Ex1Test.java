package fr.sma.aoc.adventofcode2015.solution.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day07Ex1Test {

  @Test
  public void test1() throws Exception {
    String input = """
      x LSHIFT 2 -> f
      y RSHIFT 2 -> g
      123 -> x
      x AND y -> d
      x OR y -> e
      NOT x -> h
      456 -> y
      NOT y -> i""";
    Day07Ex1 day07Ex1 = new Day07Ex1("d");
    String result = day07Ex1.run(input);
    assertEquals("72", result);
  }
}
