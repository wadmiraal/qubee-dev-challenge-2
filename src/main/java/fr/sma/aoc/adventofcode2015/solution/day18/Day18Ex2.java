package fr.sma.aoc.adventofcode2015.solution.day18;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class Day18Ex2 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"18", "1"});
  }

  @Override
  public String run(String input) throws IOException {

    String[] lines = input.split("\n");
    char[][] map = new char[lines.length][lines.length];

    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      map[i] = line.toCharArray();
    }

    print(map);
    for (int i = 0; i < 100; i++) {
      map = nextIteration(map);
      System.out.println("-------------------------------------------------------------------");
      print(map);
      Runtime.getRuntime().exec("clear");
    }

    System.out.println(count(map));

    return String.valueOf(count(map));
  }

  private static void print(char[][] map) {
    for (char[] chars : map) {
      System.out.println(chars);
    }
  }

  private static int count(char[][] map) {
    int total = 0;
    for (int x = 0; x < map.length; x++) {
      for (int y = 0; y < map.length; y++) {
        if (map[x][y] == '#') total++;
      }
    }
    return total;
  }

  private char[][] nextIteration(char[][] map) {
    char[][] result = new char[map.length][map.length];

    for (int x = 0; x < map.length; x++) {
      for (int y = 0; y < map.length; y++) {

        if(x == 0 && y == 0){
          result[x][y] = '#';
          continue;
        }
        if(x == 0 && y == map.length-1){
          result[x][y] = '#';
          continue;
        }
        if(x == map.length-1 && y == map.length-1){
          result[x][y] = '#';
          continue;
        }
        if(x == map.length-1 && y == 0){
          result[x][y] = '#';
          continue;
        }

        int neighbors = computeNeighbors(map, x, y);
        if (map[x][y] == '#') {
          if (neighbors != 2 && neighbors != 3) {
            result[x][y] = '.';
          } else {
            result[x][y] = '#';
          }
        } else {
          if (neighbors == 3) {
            result[x][y] = '#';
          } else {
            result[x][y] = '.';
          }
        }
      }
    }
    return result;
  }

  private int computeNeighbors(char[][] map, int x, int y) {
    int total = 0;
    if (y - 1 >= 0 && x - 1 >= 0) {
      total += map[x - 1][y - 1] == '#' ? 1 : 0; //1
    }
    if (y - 1 >= 0) {
      total += map[x][y - 1] == '#' ? 1 : 0; // 2
    }
    if (y - 1 >= 0 && x + 1 < map.length) {
      total += map[x + 1][y - 1] == '#' ? 1 : 0; // 3
    }
    if (x + 1 < map.length) {
      total += map[x + 1][y] == '#' ? 1 : 0; // 4
    }
    if (x + 1 < map.length && y + 1 < map.length) {
      total += map[x + 1][y + 1] == '#' ? 1 : 0; // 5
    }
    if (y + 1 < map.length) {
      total += map[x][y + 1] == '#' ? 1 : 0; // 6
    }
    if (x - 1 >= 0 && y + 1 < map.length) {
      total += map[x - 1][y + 1] == '#' ? 1 : 0; // 7
    }
    if (x - 1 >= 0) {
      total += map[x - 1][y] == '#' ? 1 : 0; // 8
    }
    return total;
  }

}
