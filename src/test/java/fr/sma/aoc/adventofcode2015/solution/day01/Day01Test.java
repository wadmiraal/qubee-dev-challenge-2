package fr.sma.aoc.adventofcode2015.solution.day01;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day01Test {

  @Test
  void run() throws Exception {
    for (int i = 0; i < INPUTS_PART1.size(); i++) {
      var inputPart1 = INPUTS_PART1.get(i);
      var inputPart2 = INPUTS_PART2.get(i);
      var expectedPart1 = EXPECTED_PART1.get(i);
      var expectedPart2 = EXPECTED_PART2.get(i);

      assert new Day01Ex1().run(inputPart1).equals(expectedPart1);
      assert new Day01Ex2().run(inputPart2).equals(expectedPart2);
    }
  }

  private final List<String> INPUTS_PART1 = List.of("(())", "(((", "()()(()()()(()()((()((()))((()((((()()((((()))()((((())(((((((()(((((((((()(((())(()()(()((()()(()(())(()((((()((()()()((((())((((((()(()(((()())(()((((()))())(())(()(()()))))))))((((((((((((()())()())())(())))(((()()()((((()(((()(()(()()(()(()()(()(((((((())(())(())())))((()())()((((()()((()))(((()()()())))(())))((((())(((()())(())(()))(()((((()())))())((()(())(((()((((()((()(())())))((()))()()(()(()))))((((((((()())((((()()((((()(()())(((((()(()())()))())(((()))()(()(()(()((((()(())(()))(((((()()(()()()(()(((())())(((()()(()()))(((()()(((())())(()(())())()()(())()()()((()(((()(())((()()((())()))((()()))((()()())((((()(()()(()(((()))()(()))))((()(((()()()))(()(((())()(()((()())(()(()()(()())(())()(((()(()())()((((()((()))))())()))((()()()()(())()())()()()((((()))))(()(((()()(((((((())()))()((((()((())()(()())(())()))(()(()())(((((((())))(((()))())))))()))())((())(()()((())()())()))))()((()()())(())((())((((()())())()()()(((()))())))()()))())(()()()(()((((((()()))())()))()(((()(((())((((()()()(()))())()()))))())()))())((())()())(((((())())((())())))(((())(((())(((((()(((((())(()(()())())(()(())(()))(()((((()))())()))))())))((()(()))))())))(((((())()))())()))))()))))(((()))()))))((()))((()((()(()(())()())))(()()()(())()))()((((())))))))(())(()((()()))(()))(()))(()((()))))))()()((((()()))()())()))))))()()()))(()((())(()))((()()()())()(((()((((())())))()((((()(()))))))())))()()())()))(()))))(()())()))))))((())))))))())()))()((())())))(()((()))()))(())))))(()))()())()()))((()(()))()()()()))))())()()))())(())()()))()))((()))))()()(()())))))()()()))((((()))()))))(()(())))(()())))((())())(()))()))))()())))()())()())))))))))()()))))())))((())((()))))())))(((()())))))))(()))()()))(()))()))))()())))))())((((()())))))))())))()()))))))))()))()))))()))))))(())))))))))())))))))))))))))())())((())))))))))()))((())))()))))))))())()(()))))))())))))()()()())()(()()()(()())(()))()()()(()())))())())))()))))())))))))()()()()())(())())()())()))))(()()()()()))))()))())())))((()())()())))()))()))))(()())))()))))))))(((()))()()))))))))))))))))))))(()))(()((()))())))())(()))(()(()(())))))()(()))()))()()))))))))))))()((()())(())())()(())))))())()())((()()))))(()()))))())()(())()))))))))))))))))))))()))(()(()())))))))()()((()))()))))))((())))()))))))))((()))())()()))())()()))((()))())))))))))))(()())()))(())((()(()()))(()())(())))()())(()(())()()))))()))()(()))))))(()))))))))))(()))())))))))))())))))())))(())))))()))))(())())))))))))()(()))))()())))())(()))()())))))))))))))())()()))))()))))))())))))()))))(())(()()()()((())()))())(()))((())()))())())(())(()()))))()))(())()()((())(())))(())))()))())))))))))()(((((())())))(())()))))(())))((()))()(((((((()))))()()))(())))))()(()))))(()()))()))())))))))(()())()))))))))())))(()))())()))(())()((())())()())())(()(()))))()))))))((()())(())()()(()())))()()))(())(())(()))())))()))(()))()()))((((()))))()))((()()()))))()))()))())))(()))()))))(())))()))())()(()))()())))())))))))())))())))()()))))))(()))())())))()))()()())())))))))))))))())))()))(()()))))())))())()(())))())))))))))))))))))()()())())))))()()()((()(()))()()(())()())()))()))))()()()))))))((()))))))))()(()(()((((((()()((()())))))))))))()))())))))((())())(()))())))())))))())()()())(())))())))()())())(())))))))()()(())))()))())))())())())()))))))))()))(()()()())())())))(())())))))))()()())()))))())))())()(())())))))))()())()))(()()(())())))()(()((()()((()()(((((())(()())()))(())()))(())))(())))))))()))()))((()))()))()))))))))()))))))))((()()())(()))(((()))(())))()))((())(((())))()())))())))))((())))))(())())((((((())())()(()))()(()((()())))((())()(()(()))))(())(()()())(())))())((()(((())())))(((()())())))())()(())())((((()()))))())((()))()()()()(())(((((((()()()((()))())(()())))(())())((((()()(()))))()((())))((())()))()(((()))())))()))((()(()))(())(()((((())((((()()(()()))(((())(()))))((((()(()))(())))))((()))(()))((()(((()(()))(()(()((()(())(()(()(()(()()((()))())(((())(()(()))))(()))()()))(())))(())()(((())(()))()((((()()))))())(()))))((())()((((()(((()))())())(((()))()())((())(())())(())()(())()(()()((((((()()))))()()(((()()))))()())()(((()(()))(()(()())(()(()))))(((((()(((())())))))(((((()((()()((())())((((((()(())(()()((()()()()()()()(()()))()(((()))()))(((((((())(((()((()())()((((())(((()(())))()((()(()()()((())((()())()))()))())))())((((((()))(()(()()()))(()((()(()(()))()((()(((()()()((())(((((())()(()))())())((()(())))(()(()())(())((())())())(((()()()(())))))())(()))))))()))))))())((()()()))((()((((((()))(((()((((()()()(((()))())()(()()(((()((()()()()())()()))()()()(()(())((()))))(()))())))))))()(()()(((((())()(()(((((()((()(()()())(()((((((((()((((((())()((((()()()((()((()((((((()))((())))))))())()))((()(()))()(()()(()((())((()()((((((((((((()())(()()()))((((()((((((())(()))())(()()((()()))()(((((((()((()()((((((()(((())))((())))((((((((()()(((((((())(((((()())(((())((())()((((()(((((((()(()(((()((((((()(((()(((((((((((()()((()()(()))((()()(((()(((())))((((())()(()(((())()(()(((())(((((((((((()))())))((((((())((()()((((()())())((((()()))((())(((((()(()()(()()()((())(()((()()((((()(((((()((()(()((((()())((((((()(((((()()(()(()((((())))(())(())(())((((()(()()((((()((((()()((()((((((())))(((((()))))()))(()((((((((()(((())())(((())))(()(()((())(((()((()()(((((()((()()(((())()(()))(((((((())(()(((((()))((()((()((()))(())())((((()((((())()(()))(((()(((((((((((((((())(((((((((()))(((()(()()()()((((((()((())()((((((((()(())(((((((((((()(()((())()((()()(()(()()((((()()((())(()((()()(()()((((()(((((((())))((((())(())()(((()()((()()((((()((()(((()((())(((()()()((((()((((()()(()(()((((((((())(()(((((())(()())(((((((()())()(()((((()((())(()()())((((()()(((()((((())(())(()()(((((((((()()))()(((())(()(()((((((())(()()())(()))()()(((()(((()((())(()(((((((()(()(()((()(((((()(()((()(()((((((()((((()()((((()(((()((())(()(()((()()((((()()(())()(())(((())(()((((((((()())(((((((((()(())()((((())))()))()()(((((()()((((((())(()()(((()(()(((((((()(()(((((((())(())((((()((()(())))((((()()())(()))((()())((((()(((((()(()(())(()(()()())(((((()(((((()((((()()((((((((()()))(()((((((())((((())()(()(((()()()(((()(()(())(())(((((()(())())((((())(())(()(((()(((((())((((())())((()(((((((()(((())(()(()))(((((((((()((()((()()(()((((())(((()((())((((())(()(((()(((()(()((((()(((())(()(((()(()()(()(()((()()(()())(())())((()(()(((()(((()(((()()(((((((((()(((((((((()()(((()(((()())((((()(()(((()()()((())((((((((((())(()(((()((((()())((((()((()))(((()()()(((((()(((((((())((()())(()((((())((((((((())(()((()((((((((((()()((()((()()))(((()())()())()(((()())()()(()(()(((((((())()))(())()))())()()((())()((()((((()((()((())(((((()((((((()(())))(()))())(((()))((()()(()(((()))((((())()(((()))))()(()(())()(((((())(()(()(())(())()((()()()((((()(())((()())(()(()))(()(()(()()(())()()(()((())()((()))))()))((()(()()()()((()())(()))())()(()(((((((((())())((()((()((((((())()((((())(((())((()(()()()((())(()((())(((()((((()()((()(()(((((())()))()((((((()))((())(((()()))(((())(())()))(((((((())(())())()(())(((((()))()((()))()(()()((()()()()()())(((((((");
  private final List<String> INPUTS_PART2 = List.of(")", "()())", "()()(()()()(()()((()((()))((()((((()()((((()))()((((())(((((((()(((((((((()(((())(()()(()((()()(()(())(()((((()((()()()((((())((((((()(()(((()())(()((((()))())(())(()(()()))))))))((((((((((((()())()())())(())))(((()()()((((()(((()(()(()()(()(()()(()(((((((())(())(())())))((()())()((((()()((()))(((()()()())))(())))((((())(((()())(())(()))(()((((()())))())((()(())(((()((((()((()(())())))((()))()()(()(()))))((((((((()())((((()()((((()(()())(((((()(()())()))())(((()))()(()(()(()((((()(())(()))(((((()()(()()()(()(((())())(((()()(()()))(((()()(((())())(()(())())()()(())()()()((()(((()(())((()()((())()))((()()))((()()())((((()(()()(()(((()))()(()))))((()(((()()()))(()(((())()(()((()())(()(()()(()())(())()(((()(()())()((((()((()))))())()))((()()()()(())()())()()()((((()))))(()(((()()(((((((())()))()((((()((())()(()())(())()))(()(()())(((((((())))(((()))())))))()))())((())(()()((())()())()))))()((()()())(())((())((((()())())()()()(((()))())))()()))())(()()()(()((((((()()))())()))()(((()(((())((((()()()(()))())()()))))())()))())((())()())(((((())())((())())))(((())(((())(((((()(((((())(()(()())())(()(())(()))(()((((()))())()))))())))((()(()))))())))(((((())()))())()))))()))))(((()))()))))((()))((()((()(()(())()())))(()()()(())()))()((((())))))))(())(()((()()))(()))(()))(()((()))))))()()((((()()))()())()))))))()()()))(()((())(()))((()()()())()(((()((((())())))()((((()(()))))))())))()()())()))(()))))(()())()))))))((())))))))())()))()((())())))(()((()))()))(())))))(()))()())()()))((()(()))()()()()))))())()()))())(())()()))()))((()))))()()(()())))))()()()))((((()))()))))(()(())))(()())))((())())(()))()))))()())))()())()())))))))))()()))))())))((())((()))))())))(((()())))))))(()))()()))(()))()))))()())))))())((((()())))))))())))()()))))))))()))()))))()))))))(())))))))))())))))))))))))))())())((())))))))))()))((())))()))))))))())()(()))))))())))))()()()())()(()()()(()())(()))()()()(()())))())())))()))))())))))))()()()()())(())())()())()))))(()()()()()))))()))())())))((()())()())))()))()))))(()())))()))))))))(((()))()()))))))))))))))))))))(()))(()((()))())))())(()))(()(()(())))))()(()))()))()()))))))))))))()((()())(())())()(())))))())()())((()()))))(()()))))())()(())()))))))))))))))))))))()))(()(()())))))))()()((()))()))))))((())))()))))))))((()))())()()))())()()))((()))())))))))))))(()())()))(())((()(()()))(()())(())))()())(()(())()()))))()))()(()))))))(()))))))))))(()))())))))))))())))))())))(())))))()))))(())())))))))))()(()))))()())))())(()))()())))))))))))))())()()))))()))))))())))))()))))(())(()()()()((())()))())(()))((())()))())())(())(()()))))()))(())()()((())(())))(())))()))())))))))))()(((((())())))(())()))))(())))((()))()(((((((()))))()()))(())))))()(()))))(()()))()))())))))))(()())()))))))))())))(()))())()))(())()((())())()())())(()(()))))()))))))((()())(())()()(()())))()()))(())(())(()))())))()))(()))()()))((((()))))()))((()()()))))()))()))())))(()))()))))(())))()))())()(()))()())))())))))))())))())))()()))))))(()))())())))()))()()())())))))))))))))())))()))(()()))))())))())()(())))())))))))))))))))))()()())())))))()()()((()(()))()()(())()())()))()))))()()()))))))((()))))))))()(()(()((((((()()((()())))))))))))()))())))))((())())(()))())))())))))())()()())(())))())))()())())(())))))))()()(())))()))())))())())())()))))))))()))(()()()())())())))(())())))))))()()())()))))())))())()(())())))))))()())()))(()()(())())))()(()((()()((()()(((((())(()())()))(())()))(())))(())))))))()))()))((()))()))()))))))))()))))))))((()()())(()))(((()))(())))()))((())(((())))()())))())))))((())))))(())())((((((())())()(()))()(()((()())))((())()(()(()))))(())(()()())(())))())((()(((())())))(((()())())))())()(())())((((()()))))())((()))()()()()(())(((((((()()()((()))())(()())))(())())((((()()(()))))()((())))((())()))()(((()))())))()))((()(()))(())(()((((())((((()()(()()))(((())(()))))((((()(()))(())))))((()))(()))((()(((()(()))(()(()((()(())(()(()(()(()()((()))())(((())(()(()))))(()))()()))(())))(())()(((())(()))()((((()()))))())(()))))((())()((((()(((()))())())(((()))()())((())(())())(())()(())()(()()((((((()()))))()()(((()()))))()())()(((()(()))(()(()())(()(()))))(((((()(((())())))))(((((()((()()((())())((((((()(())(()()((()()()()()()()(()()))()(((()))()))(((((((())(((()((()())()((((())(((()(())))()((()(()()()((())((()())()))()))())))())((((((()))(()(()()()))(()((()(()(()))()((()(((()()()((())(((((())()(()))())())((()(())))(()(()())(())((())())())(((()()()(())))))())(()))))))()))))))())((()()()))((()((((((()))(((()((((()()()(((()))())()(()()(((()((()()()()())()()))()()()(()(())((()))))(()))())))))))()(()()(((((())()(()(((((()((()(()()())(()((((((((()((((((())()((((()()()((()((()((((((()))((())))))))())()))((()(()))()(()()(()((())((()()((((((((((((()())(()()()))((((()((((((())(()))())(()()((()()))()(((((((()((()()((((((()(((())))((())))((((((((()()(((((((())(((((()())(((())((())()((((()(((((((()(()(((()((((((()(((()(((((((((((()()((()()(()))((()()(((()(((())))((((())()(()(((())()(()(((())(((((((((((()))())))((((((())((()()((((()())())((((()()))((())(((((()(()()(()()()((())(()((()()((((()(((((()((()(()((((()())((((((()(((((()()(()(()((((())))(())(())(())((((()(()()((((()((((()()((()((((((())))(((((()))))()))(()((((((((()(((())())(((())))(()(()((())(((()((()()(((((()((()()(((())()(()))(((((((())(()(((((()))((()((()((()))(())())((((()((((())()(()))(((()(((((((((((((((())(((((((((()))(((()(()()()()((((((()((())()((((((((()(())(((((((((((()(()((())()((()()(()(()()((((()()((())(()((()()(()()((((()(((((((())))((((())(())()(((()()((()()((((()((()(((()((())(((()()()((((()((((()()(()(()((((((((())(()(((((())(()())(((((((()())()(()((((()((())(()()())((((()()(((()((((())(())(()()(((((((((()()))()(((())(()(()((((((())(()()())(()))()()(((()(((()((())(()(((((((()(()(()((()(((((()(()((()(()((((((()((((()()((((()(((()((())(()(()((()()((((()()(())()(())(((())(()((((((((()())(((((((((()(())()((((())))()))()()(((((()()((((((())(()()(((()(()(((((((()(()(((((((())(())((((()((()(())))((((()()())(()))((()())((((()(((((()(()(())(()(()()())(((((()(((((()((((()()((((((((()()))(()((((((())((((())()(()(((()()()(((()(()(())(())(((((()(())())((((())(())(()(((()(((((())((((())())((()(((((((()(((())(()(()))(((((((((()((()((()()(()((((())(((()((())((((())(()(((()(((()(()((((()(((())(()(((()(()()(()(()((()()(()())(())())((()(()(((()(((()(((()()(((((((((()(((((((((()()(((()(((()())((((()(()(((()()()((())((((((((((())(()(((()((((()())((((()((()))(((()()()(((((()(((((((())((()())(()((((())((((((((())(()((()((((((((((()()((()((()()))(((()())()())()(((()())()()(()(()(((((((())()))(())()))())()()((())()((()((((()((()((())(((((()((((((()(())))(()))())(((()))((()()(()(((()))((((())()(((()))))()(()(())()(((((())(()(()(())(())()((()()()((((()(())((()())(()(()))(()(()(()()(())()()(()((())()((()))))()))((()(()()()()((()())(()))())()(()(((((((((())())((()((()((((((())()((((())(((())((()(()()()((())(()((())(((()((((()()((()(()(((((())()))()((((((()))((())(((()()))(((())(())()))(((((((())(())())()(())(((((()))()((()))()(()()((()()()()()())(((((((");
  private final List<String> EXPECTED_PART1 = List.of("0", "3", "280");
  private final List<String> EXPECTED_PART2 = List.of("1", "5", "1797");
}
