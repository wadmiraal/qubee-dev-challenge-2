package fr.sma.aoc.adventofcode2015.solution.day16;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day16Ex2 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day16Ex2.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"16", "2"});
  }

  @Override
  public String run(String input) throws Exception {
    logger.atInfo().log("input: {}", input);
    Map<String, Integer> fingerprint = Arrays.stream("""
      children: 3
      cats: 7
      samoyeds: 2
      pomeranians: 3
      akitas: 0
      vizslas: 0
      goldfish: 5
      trees: 3
      cars: 2
      perfumes: 1""".split("\n")).collect(Collectors.toMap(line -> line.split(": ")[0], line -> Integer.parseInt(line.split(": ")[1])
    ));

    var list = Arrays.stream(input.trim().split("\n"))
      .filter(line -> Arrays.stream(line.replaceAll("Sue \\d+: ", "")
        .split(", ")).noneMatch(values -> {
        String key = values.split(": ")[0];
        Integer value = Integer.parseInt(values.split(": ")[1]);

        if (Set.of("cats", "trees").contains(key)) {
          return fingerprint.get(key) >= value;
        }

        if (Set.of("pomeranians", "goldfish").contains(key)) {
          return fingerprint.get(key) <= value;
        }

        return !Objects.equals(fingerprint.get(key), value);
      })).map(line -> line.split(" ")[1].replace(":", "")).toList();

    return list.get(0);
  }
}
