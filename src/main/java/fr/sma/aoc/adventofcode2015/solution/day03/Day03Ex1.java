package fr.sma.aoc.adventofcode2015.solution.day03;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day03Ex1 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day03Ex1.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"03", "1"});
  }

  @Override
  public String run(String input) throws Exception {
    logger.atInfo().log("input: {}", input);
    return input;
  }
}
