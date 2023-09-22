package fr.sma.aoc.adventofcode2015.solution.day17;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class Day17Ex2 implements ExSolution {

  private final int targetLiter;

  public Day17Ex2(int targetLiter) {
    this.targetLiter = targetLiter;
  }

  public Day17Ex2() {
    this(150);
  }

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"17", "2"});
  }

  @Override
  public String run(String input) {
    AtomicInteger count = new AtomicInteger(0);
    Set<Container> jars = Arrays.stream(input.trim().split("\n"))
      .map(s -> new Container(count.getAndIncrement(), Integer.parseInt(s)))
      .collect(Collectors.toSet());

    Set<Set<Container>> combinations = findCombinations(jars, targetLiter, Set.of());
    int minSize = combinations
      .stream().mapToInt(Set::size)
      .min().getAsInt();

    return combinations.stream().filter(s -> s.size() == minSize)
      .count() + "";
  }

  private Set<Set<Container>> findCombinations(Set<Container> remainingJars, int remainingVolume, Set<Container> currentlyFilled) {
    if(remainingVolume == 0) {
      return Set.of(Set.copyOf(currentlyFilled));
    }

    if(currentlyFilled.size() > 5) {
      return Set.of();
    }

    Set<Set<Container>> matchingCombination = new HashSet<>();
    for (Container jar : remainingJars) {
      if(remainingVolume < jar.volume) {
        continue;
      }
      var nextRemainings = new HashSet<>(remainingJars);
      nextRemainings.remove(jar);
      var nextFilled = new HashSet<>(currentlyFilled);
      nextFilled.add(jar);
      matchingCombination.addAll(
        findCombinations(nextRemainings, remainingVolume - jar.volume, nextFilled)
      );
    }
    return matchingCombination;
  }

  public record Container(int id, int volume){}
}
