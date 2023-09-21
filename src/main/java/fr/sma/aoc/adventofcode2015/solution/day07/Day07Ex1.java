package fr.sma.aoc.adventofcode2015.solution.day07;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.emulator.Emulator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day07Ex1 implements ExSolution {

  private final String wantedLetter;
  private static final Logger logger = LoggerFactory.getLogger(Day07Ex1.class);

  public Day07Ex1() {
    wantedLetter = "a";
  }

  public Day07Ex1(String wantedLetter) {
    this.wantedLetter = wantedLetter;
  }

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"07", "1"});
  }

  @Override
  public String run(String input) throws Exception {
    ArrayList<String> instructions = Stream.of(input.trim().split("\n"))
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
