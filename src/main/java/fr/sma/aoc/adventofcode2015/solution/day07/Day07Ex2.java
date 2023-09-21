package fr.sma.aoc.adventofcode2015.solution.day07;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.emulator.Emulator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day07Ex2 implements ExSolution {

  private final String wantedLetter;

  private final int bValue;
  private static final Logger logger = LoggerFactory.getLogger(Day07Ex2.class);

  public Day07Ex2() {
    wantedLetter = "a";
    bValue = 16076;
  }

  public Day07Ex2(String wantedLetter, int bValue) {
    this.wantedLetter = wantedLetter;
    this.bValue = bValue;
  }

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"07", "2"});
  }

  @Override
  public String run(String input) throws Exception {

    ArrayList<String> instructions = Stream.of(input.trim().split("\n"))
      .map(line -> line.contains("19138 -> b")? bValue + " -> b": line)
      .collect(Collectors.toCollection(ArrayList::new));

    Map<String, Character> registers = new HashMap<>();

    int size;
    do {
      size = instructions.size();
      instructions.removeIf(s -> Emulator.executeInstruction(s, registers));
    } while (size > instructions.size());

    return String.valueOf((int) registers.get(wantedLetter));
  }
}
