package fr.sma.aoc.adventofcode2015.solution.day12;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Day12Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"12", "1"});
  }

  @Override
  public String run(String input) {
    String result = input.replaceAll("[^0-9\\-]", " ");
    List<Integer> list = Arrays.stream(result.split(" "))
      .filter(c -> !c.isEmpty())
      .map(Integer::parseInt)
      .toList();
    return String.valueOf(list.stream().mapToInt(Integer::intValue).sum());
  }
}
