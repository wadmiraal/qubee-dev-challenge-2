package fr.sma.aoc.adventofcode2015.solution.day23;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import org.springframework.stereotype.Component;

@Component
public class Day23Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"23", "1"});
  }

  @Override
  public String run(String input) {

    int a = 1; // 0 for part 1
    int b = 0;

    var lines = input.split("\n");

    int i = 0;
    boolean run = true;
    while (run) {
      if (i < 0 || i >= lines.length) {
        System.out.println("break, i = " + i);
        break;
      }


      String instruction = lines[i];
      System.out.println("execute " + instruction + String.format("a=%s, b=%s, i=%s", a, b, i));

      if (instruction.startsWith("hlf")) {
        if (instruction.split(" ")[1].charAt(0) == 'a') {
          a = a / 2;
        } else if (instruction.split(" ")[1].charAt(0) == 'b') {
          b = b / 2;
        } else {
          throw new RuntimeException("aie");
        }
        i++;
      } else if (instruction.startsWith("tpl")) {
        if (instruction.split(" ")[1].charAt(0) == 'a') {
          a = a * 3;
        } else if (instruction.split(" ")[1].charAt(0) == 'b') {
          b = a * 3;
        } else {
          throw new RuntimeException("aie");
        }
        i++;
      } else if (instruction.startsWith("inc")) {
        if (instruction.split(" ")[1].charAt(0) == 'a') {
          a++;
        } else if (instruction.split(" ")[1].charAt(0) == 'b') {
          b++;
        } else {
          throw new RuntimeException("aie");
        }
        i++;
      } else if (instruction.startsWith("jmp")) {
        Integer jumpValue = Integer.valueOf(instruction.split(" ")[1]);
        i += jumpValue;
      } else if (instruction.startsWith("jie")) {
        char register = instruction.replace("jie", "").trim().split(",")[0].charAt(0);
        int offset = Integer.valueOf(instruction.replace("jie", "").trim().split(",")[1].trim());
        if (register == 'a') {
          if (a % 2 == 0) {
            i += offset;
          } else {
            i++;
          }
        } else if (register == 'b') {
          if (b % 2 == 0) {
            i += offset;
          } else {
            i++;
          }
        } else {
          throw new RuntimeException("aie");
        }
      } else if (instruction.startsWith("jio")) {
        char register = instruction.replace("jio", "").trim().split(",")[0].charAt(0);
        int offset = Integer.parseInt(instruction.replace("jio", "").trim().split(",")[1].trim());
        if (register == 'a') {
          if (a == 1) {
            i += offset;
          } else {
            i++;
          }
        } else if (register == 'b') {
          if (b == 1) {
            i += offset;
          } else {
            i++;
          }
        } else {
          throw new RuntimeException("aie");
        }
      } else {
        run = false;
      }
    }

    System.out.println("a : " + a);
    System.out.println("b : " + b);
    return input;
  }


}
