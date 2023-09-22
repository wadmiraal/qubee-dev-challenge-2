package fr.sma.aoc.adventofcode2015.solution.day20;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Day20Ex2 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"20", "2"});
  }

  @Override
  public String run(String input) {
    int house = 1;
    while (compute(house) < Integer.parseInt(input.trim())) {
      house++;
    }
    return "" + house;
  }

  Integer compute(int house) {
    List<Integer> dividers = calculateDividers(house);
    return dividers.stream().mapToInt(i -> i).sum() * 11;
  }

  private List<Integer> calculateDividers(int house) {
    List<Integer> dividers = new ArrayList<>();

    for (int i = 1; i <= Math.sqrt(house); i++) {
      if (house % i == 0) {
        int d1 = i;
        int d2 = house / i;
        if (d1 <= 50) {
          dividers.add(d2);
        }
        if (d2 <= 50) {
          dividers.add(d1);
        }
      }
    }

    return dividers;
  }
}
