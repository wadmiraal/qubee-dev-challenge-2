package fr.sma.aoc.adventofcode2015.solution.day05;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Coordinate;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day05Ex1 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day05Ex1.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"05", "1"});
  }

  @Override
  public String run(String input) {
    logger.atInfo().log("input: {}", input);
    String[] inputList = input.split("\n");

    List<String> words = new ArrayList<>();

    for (String word : inputList) {
      if (word.contains("ab") || word.contains("cd") || word.contains("pq") || word.contains("xy")) {
        continue;
      }
      char previous = ' ';
      List<Character> vowels = new ArrayList<>();
      boolean duplicate = false;
      for (char current : word.toCharArray()) {
        if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
          vowels.add(current);
        }
        if (current == previous) {
          duplicate = true;
        }
        previous = current;
      }
      if (vowels.size() >= 3 && duplicate) {
        words.add(word);
      }
    }

    return String.valueOf(words.size());
  }
}
