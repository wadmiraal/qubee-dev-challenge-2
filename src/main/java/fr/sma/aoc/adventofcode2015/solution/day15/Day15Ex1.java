package fr.sma.aoc.adventofcode2015.solution.day15;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Day15Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"15", "1"});
  }

  @Override
  public String run(String input) {

    //System.out.println(input);

    /**
     Sprinkles: capacity 2, durability 0, flavor -2, texture 0, calories 3
     Butterscotch: capacity 0, durability 5, flavor -3, texture 0, calories 3
     Chocolate: capacity 0, durability 0, flavor 5, texture -1, calories 8
     Candy: capacity 0, durability -1, flavor 0, texture 5, calories 8

     {0=92, 1=5, 2=3}

     capacity = 92*2 = 184
     durability = 5*5 + -1*5 = 25 - 5 = 20
     flavor = -2*92 + -3*5 + 5*3 = -184 - 15 - 15 = -184
     texture = -1*3 = -3

     182*13*6*0 = {0=91, 1=3, 2=4, 3=2} = 14196

     */

    String[] lines = input.trim().split("\n");
    int[][] array = new int[lines.length][5];

    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      int[] caracteristics = Arrays.stream(line.split(": ")[1].split(",")).toList()
        .stream().mapToInt(s -> Integer.parseInt(s.trim().split(" ")[1]))
        .toArray();
      array[i] = caracteristics;
    }

    for (int i = 0; i < array.length; i++) {
      System.out.println(Arrays.toString(array[i]));
    }

    Long max = 0L;
    for (int j = 0; j < array.length; j++) {
      Long computed = compute(100, array, Collections.emptyMap(), j);
      max = computed > max ? computed : max;
    }
    return String.valueOf(max);
  }

  public Long compute(int count, int[][] array, Map<Integer, Integer> recette, int indexToUse) {
    if (count == 0) {
      Long scoreTotal = 1L;
      for (int i = 0; i < 4; i++) {
        Long scoreCaracteristics = 0L;
        for (int j = 0; j < array.length; j++) {
          scoreCaracteristics += array[j][i] * recette.getOrDefault(j, 0);
        }

        if(scoreCaracteristics < 0){
          scoreCaracteristics = 0L;
        }
        scoreTotal *= scoreCaracteristics;
      }

      if(scoreTotal > 0){
        System.out.println(recette + " = " + scoreTotal);

      }
      return scoreTotal;
    }

    Map<Integer, Integer> nextRecette = new HashMap<>(recette);
    Integer currentCount = nextRecette.computeIfAbsent(indexToUse, a -> 0);
    nextRecette.replace(indexToUse, currentCount + 1);


    Long max = 0L;
    for (int j = 0; j < array.length; j++) {
      Long computed = compute(count - 1, array, nextRecette, j);
      max = computed > max ? computed : max;
    }
    return  max;
  }
}
