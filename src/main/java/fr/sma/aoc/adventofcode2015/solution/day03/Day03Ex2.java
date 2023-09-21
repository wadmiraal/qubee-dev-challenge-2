package fr.sma.aoc.adventofcode2015.solution.day03;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day03Ex2 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day03Ex2.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"03", "2"});
  }

  @Override
  public String run(String input) {
    logger.atInfo().log("input: {}", input);

    Set<Coordinate> visitedSanta = new HashSet<>();
    Set<Coordinate> visitedRobo = new HashSet<>();
    boolean visitSanta = true;

    visitedSanta.add(new Coordinate(0,0));
    visitedRobo.add(new Coordinate(0,0));

    Coordinate coordSanta = new Coordinate(0, 0);
    Coordinate coordRobo = new Coordinate(0, 0);

    for (char instr : input.toCharArray()) {
      Coordinate toVisit = visitSanta ? coordSanta : coordRobo;

      switch(instr) {
        case '<':
          toVisit.offsetX(-1);
          break;
        case '>':
          toVisit.offsetX(1);
          break;
        case '^':
          toVisit.offsetY(1);
          break;
        case 'v':
          toVisit.offsetY(-1);
          break;
      }
      if (visitSanta) {
        visitedSanta.add(new Coordinate(toVisit.getX(), toVisit.getY()));
        visitSanta = false;
      } else {
        visitedRobo.add(new Coordinate(toVisit.getX(), toVisit.getY()));
        visitSanta = true;
      }
    }

    visitedSanta.addAll(visitedRobo);

    return String.valueOf(visitedSanta.size());
  }
}
