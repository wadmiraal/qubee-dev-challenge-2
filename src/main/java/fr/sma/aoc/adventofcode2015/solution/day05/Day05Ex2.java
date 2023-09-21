package fr.sma.aoc.adventofcode2015.solution.day05;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Coordinate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day05Ex2 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day05Ex2.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"05", "2"});
  }

  @Override
  public String run(String input) {
    logger.atInfo().log("input: {}", input);
    String[] inputList = input.split("\n");

    List<String> words = new ArrayList<>();

    for (String word : inputList) {
      List<String> pairs = new ArrayList<>();

      boolean duplicatePair = false;
      boolean repeat = false;
      String pair = "";
      for (int i = 0; i < word.length(); i++) {
        char current = word.charAt(i);

        pair += String.valueOf(current);
        if (pair.length() == 2) {

          if (pairs.size() > 1 && pairs.subList(0, pairs.size() -1).contains(pair)) {
            duplicatePair = true;
          }

          pairs.add(pair);
          pair = pair.substring(1);
        }

        if (i > 1 && current == word.charAt(i - 2)) {
          repeat = true;
        }
      }

      if (duplicatePair && repeat) {
        words.add(word);
      }
    }

    return String.valueOf(words.size());
  }
}
