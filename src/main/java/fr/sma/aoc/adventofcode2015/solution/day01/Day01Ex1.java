package fr.sma.aoc.adventofcode2015.solution.day01;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day01Ex1 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day01Ex1.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"01", "1"});
  }

  @Override
  public String run(String input) throws Exception {
    logger.atInfo().log("input: {}", input);
    Long result = input.chars().filter(ch -> ch == '(').count() - input.chars().filter(ch -> ch == ')').count();
    return result.toString();
  }
}
