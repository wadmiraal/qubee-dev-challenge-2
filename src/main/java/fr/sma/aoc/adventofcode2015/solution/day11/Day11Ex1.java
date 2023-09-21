package fr.sma.aoc.adventofcode2015.solution.day11;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import one.util.streamex.IntStreamEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day11Ex1 implements ExSolution {
  Logger logger = LoggerFactory.getLogger(Day11Ex1.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"11", "1"});
  }

  @Override
  public String run(String input) throws Exception {
    logger.atInfo().log("input: {}", input);
    var chars = new char[8];
    var letters = input.trim().split("");
    for (int i = 0; i < letters.length; ++i) {
      chars[i] = (char) letters[i].codePointAt(0);
    }

    do {
      addOne(chars);
    } while (!isValid(chars));

    return new String(chars);
  }

  protected void addOne(char[] chars) {
    addOne(chars, chars.length-1);
  }

  protected void addOne(char[] chars, int index) {
    if (index == -1) {
      throw new ArrayIndexOutOfBoundsException("Reached the end of the list (index " + index + ")");
    }

    char last = chars[index];

    if ('z' == last) {
      logger.atInfo().log("going back to 'a' for index: {}, pwd: {}", index, new String(chars));
      chars[index] = 'a';
      addOne(chars, index - 1);
      return;
    }

    ++last;
    if (isForbidden(last)) {
      ++last;
    }

    chars[index] = last;
  }

  protected boolean isForbidden(char c) {
    return 'o' == c || 'l' == c || 'i' == c;
  }

  protected boolean isValid(char[] chars) {
    return hasStraight(chars) && hasDoubles(chars) && !hasForbiddenChar(chars);
  }

  public static boolean hasDoubles(char[] chars) {
    return IntStreamEx.of(chars).pairMap((a,b) -> a == b ? a : 0).filter(c -> c != 0).distinct().count() > 1;
  }

  protected boolean hasForbiddenChar(char[] chars) {
    return new String(chars).contains("o") || new String(chars).contains("l") || new String(chars).contains("i");
  }

  public static boolean hasStraight(char[] chars) {
    for (int i = chars.length - 1; i >= 2; --i) {
      if (chars[i] - chars[i-1] == 1 && chars[i-1] - chars[i-2] == 1) {
        return true;
      }
    }
    return false;
  }
}
