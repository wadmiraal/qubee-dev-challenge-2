package fr.sma.aoc.adventofcode2015.solution.day07;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day07Ex1 implements ExSolution {

  private final String wantedLetter;
  private static Logger logger = LoggerFactory.getLogger(Day07Ex1.class);

  public Day07Ex1() {
    wantedLetter = "a";
  }

  public Day07Ex1(String wantedLetter) {
    this.wantedLetter = wantedLetter;
  }

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"07", "1"});
  }

  @Override
  public String run(String input) throws Exception {
    return input;
  }
}
