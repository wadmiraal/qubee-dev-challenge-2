package fr.sma.aoc.adventofcode2015.solution.day04;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day04Ex2 implements ExSolution {

  Logger logger = LoggerFactory.getLogger(Day04Ex2.class);

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"04", "2"});
  }

  @Override
  public String run(String input) throws Exception {
    final String trimedInput = input.trim();
    MessageDigest md5 = MessageDigest.getInstance("MD5");
    return IntStream.iterate(1, i -> i + 1)
      .mapToObj(Integer::toString)
      .filter(s -> {
        var byteInput = (trimedInput + s).getBytes(StandardCharsets.UTF_8);
        byte[] digest = md5.digest(byteInput);
        boolean b = HexFormat.of().formatHex(digest).startsWith("000000");
        return b;
      }).findFirst()
      .map(Object::toString)
      .get();
  }
}
