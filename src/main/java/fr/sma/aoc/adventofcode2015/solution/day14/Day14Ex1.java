package fr.sma.aoc.adventofcode2015.solution.day14;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class Day14Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"14", "1"});
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

    return "";
  }

  private record Reindeer(String name, int speed, int flyTime, int restTime) {
  }
}
