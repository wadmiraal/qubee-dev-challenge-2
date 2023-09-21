package fr.sma.aoc.adventofcode2015.solution.emulator;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.slf4j.Logger;

public class Emulator {

  private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Emulator.class);

  public static boolean executeInstruction(String instruction, Map<String, Character> register) {
    logger.atInfo().log("instruction: {}", instruction);
    return Operators.applyInstruction(instruction, register);
  }

  public enum Operators {
    AND(Pattern.compile("([a-z]+) AND (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = register.get(operands[1]);
      register.put(operands[2], (char) (op0 & op1));
    }, (operands, register) -> register.containsKey(operands[0]) && register.containsKey(operands[1])),
    ONE_AND(Pattern.compile("1 AND (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      register.put(operands[1], (char) (1 & op0));
    }, (operands, register) -> register.containsKey(operands[0])),
    OR(Pattern.compile("(\\w+) OR (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = register.get(operands[1]);
      register.put(operands[2], (char) (op0 | op1));
    }, (operands, register) -> register.containsKey(operands[0]) && register.containsKey(operands[1])),
    NOT(Pattern.compile("NOT (\\w+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      register.put(operands[1], (char) ~op0);
    }, (operands, register) -> register.containsKey(operands[0])),
    LSHIFT(Pattern.compile("(\\w+) LSHIFT (\\d+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = (char) Integer.parseInt(operands[1]);
      register.put(operands[2], (char) (op0 << op1));
    }, (operands, register) -> register.containsKey(operands[0])),
    RSHIFT(Pattern.compile("(\\w+) RSHIFT (\\d+) -> (\\w+)"), (operands, register) -> {
      char op0 = register.get(operands[0]);
      char op1 = (char) Integer.parseInt(operands[1]);
      register.put(operands[2], (char) (op0 >> op1));
    }, (operands, register) -> register.containsKey(operands[0])),
    ASSIGN_VALUE(Pattern.compile("(\\d+) -> (\\w+)"), (operands, register) -> {
      register.put(operands[1], (char) Integer.parseInt(operands[0]));
    }, (operands, register) -> true),
    ASSIGN_REGISTER(Pattern.compile("(\\w+) -> (\\w+)"), (operands, register) -> {
      register.put(operands[1], register.get(operands[0]));
    }, (operands, register) -> register.containsKey(operands[0]));

    Operators(Pattern pattern, BiConsumer<String[], Map<String, Character>> handler, BiPredicate<String[], Map<String, Character>> matcher) {
      this.pattern = pattern;
      this.handler = handler;
      this.matcher = matcher;
    }

    private final Pattern pattern;
    private final BiPredicate<String[], Map<String, Character>> matcher;
    private final BiConsumer<String[], Map<String, Character>> handler;

    private boolean matches(String line) {
      return pattern.matcher(line).matches();
    }

    private boolean tryApply(String instruction, Map<String, Character> register) {
      Matcher operandsMatcher = pattern.matcher(instruction);
      if(!operandsMatcher.find()) {
        return false;
      }

      int nbOperand = operandsMatcher.groupCount();
      String[] operands = new String[nbOperand];
      for (int i = 0; i < nbOperand; i++) {
        operands[i] = operandsMatcher.group(i + 1);
      }
      if(!this.matcher.test(operands, register)) {
        return false;
      }
      handler.accept(operands, register);
      return true;
    }

    public static boolean applyInstruction(String instruction, Map<String, Character> register) {
      return Stream.of(Operators.values())
        .filter(op -> op.matches(instruction))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown operator for instruction " + instruction))
        .tryApply(instruction, register);
    }
  }
}
