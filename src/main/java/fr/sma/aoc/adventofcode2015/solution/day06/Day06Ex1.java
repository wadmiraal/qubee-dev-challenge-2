package fr.sma.aoc.adventofcode2015.solution.day06;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Day06Ex1 implements ExSolution {

    static boolean[][] grids = new boolean[1000][1000];

    Logger logger = LoggerFactory.getLogger(Day03Ex1.class);

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"06", "1"});
    }

    @Override
    public String run(String input) {
        var lines = input.split("\n");
        long result = 0;
        for (var line : lines) {
            light(line);

        }
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (grids[y][x]) {
                    result++;
                }
            }
        }
        logger.info("" + result);
        return "" + result;
    }

    private void light(String line) {
        int struction = 0;
        String grid = "";
        if (line.contains("turn on")) {
            struction =1;
            grid = line.substring(8);
        } else if (line.contains("turn off")) {
            struction =2;
            grid = line.substring(9);
        } else if (line.contains("toggle")) {
            struction = 3;
            grid = line.substring(7);
        }
        var coor = grid.split("through");
        var c1 = coor[0].trim().split(",");
        var c2 = coor[1].trim().split(",");
        var x1 = Integer.parseInt(c1[0]);
        var x2 = Integer.parseInt(c2[0]);
        var y1 = Integer.parseInt(c1[1]);
        var y2 = Integer.parseInt(c2[1]);
        switch (struction) {
            case 1:
                turnOn(x1, y1, x2, y2);
                break;
            case 2:
                turnOff(x1, y1, x2, y2);
                break;
            case 3:
                toggle(x1, y1, x2, y2);
                break;
        }
    }

    private void toggle(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                grids[y][x] = !grids[y][x];
            }
        }
    }

    private void turnOff(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                grids[y][x] = false;
            }
        }
    }

    private void turnOn(int x1, int y1, int x2, int y2) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                grids[y][x] = true;
            }
        }
    }

}
