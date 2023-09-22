package fr.sma.aoc.adventofcode2015.solution.day25;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Day25Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"25", "1"});
  }

  @Override
  public String run(String input) throws IOException {

    Long[] results = new Long[18_331_560];

    results[0] = 20151125L;

    for (int i = 1; i < 18_331_560; i++) {
      results[i] = next(results[i-1]);
    }

    for (int i = 0; i < results.length; i++) {
      //System.out.println(i + ":" + results[i]);
    }

    System.out.println(results[results.length-1]);

    return "";
  }

  private Long next(Long number) {
    return (number * 252533) % 33554393;
  }

}
