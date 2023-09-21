package fr.sma.aoc.adventofcode2015.solution.day07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day07Ex1Test {

  @Test
  public void test1() throws Exception {
    String input = """
      123 -> x
      456 -> y
      x AND y -> d
      x OR y -> e
      x LSHIFT 2 -> f
      y RSHIFT 2 -> g
      NOT x -> h
      NOT y -> i""";
    Day07Ex1 day07Ex1 = new Day07Ex1("d");
    String result = day07Ex1.run(input);
    assertEquals("72", result);
  }
}
