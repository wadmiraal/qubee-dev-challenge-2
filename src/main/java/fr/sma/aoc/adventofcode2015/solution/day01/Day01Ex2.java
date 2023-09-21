package fr.sma.aoc.adventofcode2015.solution.day01;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day01Ex2 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day01Ex2.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"01", "2"});
  }

  @Override
  public String run(String input) throws Exception {
    logger.atInfo().log("input: {}", input);
    var chars = input.chars().mapToObj(e -> (char) e).toList();
    int result = 0;
    int i = 0;
    for (char c: chars) {
      ++i;
      if (String.valueOf(c).equals("(")) {
        result++;
      } else {
        result--;
      }

      if (result < 0) {
        return Integer.toString(i);
      }
    }
    throw new Exception("nope");
  }
}
