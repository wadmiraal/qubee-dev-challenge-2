package fr.sma.aoc.adventofcode2015.solution.emulator;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emulator {

  private static void executeInstruction(String instruction, Map<String, Character> register) {
    // parse instruction
    // * split operator and operands
    // * find operator handler
    // * load operand value
    // * execute operation

    // execute on register
    // * store value
  }

  public enum Operators {
    AND(Pattern.compile(""), (operands, register) -> {

    }),
    OR(Pattern.compile(""), (operands, register) -> {

    }),
    NOT(Pattern.compile(""), (operands, register) -> {

    }),
    LSHIFT(Pattern.compile(""), (operands, register) -> {

    }),
    RSHIFT(Pattern.compile(""), (operands, register) -> {

    }),
    ASSIGN(Pattern.compile(""), (operands, register) -> {

    });

    Operators(Pattern pattern, BiConsumer<String[], Map<String, Character>> handler) {
      this.pattern = pattern;
      this.handler = handler;
    }

    private final Pattern pattern;
    private final BiConsumer<String[], Map<String, Character>> handler;

    private boolean matches(String line) {
      return pattern.matcher(line).matches();
    }

    private void apply(String instruction, Map<String, Character> register) {
      Matcher matcher = pattern.matcher(instruction);
      assert matcher.matches();

      int nbOperand = matcher.groupCount();
      char[] operands = new char[nbOperand];
      for (int i = 0; i < nbOperand; i++) {
        //operands[i] = matcher.group(i + 1);
      }
    }

    public static void applyInstruction(String instruction, Map<String, Character> register) {

    }
  }
}
