package fr.sma.aoc.adventofcode2015.solution.day13;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class Day13Ex2 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"13", "2"});
  }

  private Map<String, Map<String, Integer>> happinessWeights;

  @Override
  public String run(String input) {
    happinessWeights = parseInput(input);

    Set<String> remaining = new HashSet<>(happinessWeights.keySet());
    String firstSeated = remaining.iterator().next();
    remaining.remove(firstSeated);

    return maximizeHappiness(remaining, firstSeated, firstSeated) + "";
  }

  private int maximizeHappiness(Set<String> remainingToSeat, String previousSeated, String firstSeated) {
    if(remainingToSeat.size() == 1) {
      String currentSeated = remainingToSeat.iterator().next();
      return calculateHappiness(previousSeated, currentSeated) + calculateHappiness(currentSeated, firstSeated);
    }

    int maxHappiness = Integer.MIN_VALUE;
    for (String nextSeated : remainingToSeat) {
      Set<String> nextRemaining = new HashSet<>(remainingToSeat);
      nextRemaining.remove(nextSeated);
      int cur = calculateHappiness(previousSeated, nextSeated) + maximizeHappiness(nextRemaining, nextSeated, firstSeated);
      if(cur > maxHappiness) {
        maxHappiness = cur;
      }
    }
    return maxHappiness;
  }

  private int calculateHappiness(String one, String two) {
    return happinessWeights.get(one).get(two) + happinessWeights.get(two).get(one);
  }

  public Map<String, Map<String, Integer>> parseInput(String input) {
    Map<String, Map<String, Integer>> weights = new HashMap<>();
    Arrays.stream(input.trim().split("\n"))
      .forEach(line -> {
        String[] split = line.split(" ");
        String who = split[0];
        String sign = split[2];
        String howMany = split[3];
        String nextToWho = split[10].split("\\.")[0];

        Integer happinessGain = sign.equals("gain") ? Integer.parseInt(howMany) : -Integer.parseInt(howMany);
        weights.computeIfAbsent(who, k -> new HashMap<>()).put(nextToWho, happinessGain);
        weights.computeIfAbsent(who, k -> new HashMap<>()).put("me", 0);
        weights.computeIfAbsent("me", k -> new HashMap<>()).put(who, 0);
      });
    return weights;
  }
}
