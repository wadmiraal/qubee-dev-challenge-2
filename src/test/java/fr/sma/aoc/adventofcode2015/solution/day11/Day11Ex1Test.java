package fr.sma.aoc.adventofcode2015.solution.day11;

import one.util.streamex.StreamEx;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day11Ex1Test {

  @Test
  void run() throws Exception {
    assertEquals("abcdffaa", new Day11Ex1().run("abcdefgh"));
    assertEquals("ghjaabcc", new Day11Ex1().run("ghijklmn"));
  }

  @Test
  void hasStraight() {
    assertTrue(Day11Ex1.hasStraight("abc".toCharArray()));
    assertTrue(Day11Ex1.hasStraight("zutdefou".toCharArray()));
  }

  @Test
  void hasDoubles() {
    assertTrue(Day11Ex1.hasDoubles("zutddeffou".toCharArray()));
    assertFalse(Day11Ex1.hasDoubles("zutddeddou".toCharArray()));
  }
}
