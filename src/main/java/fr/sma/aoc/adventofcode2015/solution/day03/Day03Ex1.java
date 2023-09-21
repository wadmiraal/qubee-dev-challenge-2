package fr.sma.aoc.adventofcode2015.solution.day03;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.HashSet;
import java.util.Set;
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
  public String run(String input) {
    logger.atInfo().log("input: {}", input);

    Set<Coordinate> visited = new HashSet<>();
    visited.add(new Coordinate(0,0));

    Coordinate c = new Coordinate(0, 0);

    for (char instr : input.toCharArray()) {
      switch(instr) {
        case '<':
          c.offsetX(-1);
          break;
        case '>':
          c.offsetX(1);
          break;
        case '^':
          c.offsetY(1);
          break;
        case 'v':
          c.offsetY(-1);
          break;
      }
      visited.add(new Coordinate(c.getX(), c.getY()));
    }

    return String.valueOf(visited.size());
  }
}
