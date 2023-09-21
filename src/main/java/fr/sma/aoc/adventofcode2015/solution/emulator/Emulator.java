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
    AND(Pattern.compile("(\\w+) AND (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = register.get(operands[1]);
      register.put(operands[2], (char) (op0 & op1));
    }),
    OR(Pattern.compile("(\\w+) OR (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = register.get(operands[1]);
      register.put(operands[2], (char) (op0 | op1));
    }),
    NOT(Pattern.compile("NOT (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      register.put(operands[1], (char) ~op0);
    }),
    LSHIFT(Pattern.compile("(\\w+) LSHIFT (\\d+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = (char) Integer.parseInt(operands[1]);
      register.put(operands[2], (char) (op0 << op1));
    }),
    RSHIFT(Pattern.compile("(\\w+) RSHIFT (\\d+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = (char) Integer.parseInt(operands[1]);
      register.put(operands[2], (char) (op0 >> op1));
    }),
    ASSIGN(Pattern.compile("(\\d+) -> (\\w+)"), (operands, register) -> {
      register.put(operands[1], (char) Integer.parseInt(operands[0]));
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
