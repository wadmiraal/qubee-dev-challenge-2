package fr.sma.aoc.adventofcode2015.solution.day14;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class Day14Ex2 implements ExSolution {
  public static final int RACE_DURATION = 2503;

  public static void main(String[] args) {
    ResolveApplication.main(new String[] {"14", "2"});
  }

  @Override
  public String run(String input) {
    String[] inputList = input.split("\n");

    List<Reindeer> reindeers = new ArrayList<>();
    Pattern pattern = Pattern.compile("(.+) can fly (\\d+) km\\/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.");

    for (String line : inputList) {
      Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        reindeers.add(new Reindeer(matcher.group(1), Integer.valueOf(matcher.group(2)), Integer.valueOf(matcher.group(3)), Integer.valueOf(matcher.group(4))));
      }
    }

    Map<Reindeer, Integer> reindeerToPosition = new HashMap<>();
    Map<Reindeer, Integer> reindeerToScore = new HashMap<>();

    for (int currentTime = 0; currentTime < RACE_DURATION; currentTime++) {
      for (Reindeer reindeer : reindeers) {
        reindeerToPosition.putIfAbsent(reindeer, 0);
        reindeerToScore.putIfAbsent(reindeer, 0);

        int cycleTime = reindeer.restTime() + reindeer.flyTime();

        if (currentTime % cycleTime < reindeer.flyTime()) {
          reindeerToPosition.compute(reindeer, (reinder, position) -> position + reindeer.speed());
        }
      }

      Set<Reindeer> iterationWinners = new HashSet<>();
      int bestPosition = 0;
      for (Map.Entry<Reindeer, Integer> reinderToPos : reindeerToPosition.entrySet()) {
        Reindeer reindeer = reinderToPos.getKey();
        Integer position = reinderToPos.getValue();
        if (position > bestPosition) {
          iterationWinners.clear();
          bestPosition = position;
          iterationWinners.add(reindeer);
        }
        if (position == bestPosition) {
          iterationWinners.add(reindeer);
        }
      }
      iterationWinners.forEach(reindeer ->
        reindeerToScore.compute(reindeer, (r, previousScore) -> previousScore + 1));

    }

    return String.valueOf(
      reindeerToScore.values().stream()
        .mapToInt(i -> i)
        .max().orElseThrow()
    );


    /*Map<Reindeer, Integer> reindeerToDistance = reindeers.stream()
      .collect(Collectors.toMap(Function.identity(), r -> computeDistance(RACE_DURATION, r)));

    System.out.println(reindeerToDistance);

    return String.valueOf(reindeerToDistance.values().stream()
      .mapToInt(i -> i)
      .max()
      .orElseThrow());*/
  }

  private Integer computeDistance(int raceDuration, Reindeer reindeer) {

    int cycleTime = reindeer.restTime() + reindeer.flyTime();
    int cycleDistance = reindeer.speed() * reindeer.flyTime();

    int nbCycles = raceDuration / cycleTime;

    int totalDistance = nbCycles * cycleDistance;

    int remainingSeconds = RACE_DURATION % cycleTime;

    int remainingFlyTime = Math.min(remainingSeconds, reindeer.flyTime());
    return totalDistance + remainingFlyTime * reindeer.speed();
  }

  private record Reindeer(String name, int speed, int flyTime, int restTime) {
  }
}
