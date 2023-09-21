package fr.sma.aoc.adventofcode2015.solution.day04;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class Day04Ex1Test {

  Logger logger = LoggerFactory.getLogger(Day04Ex1Test.class);
  @Test
  void test1() throws Exception {
    String secret = "abcdef";
    Day04Ex1 day04Ex1 = new Day04Ex1();
    String result = day04Ex1.run(secret);
    assertEquals("609043", result);
  }

  @Test
  void test2() throws Exception {
    String secret = "pqrstuv";
    Day04Ex1 day04Ex1 = new Day04Ex1();
    String result = day04Ex1.run(secret);
    assertEquals("1048970", result);
  }
}
