package fr.sma.aoc.adventofcode2015.solution.day15;

import fr.sma.aoc.adventofcode2015.solution.day10.Day10Ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day15Ex1Test {

    @Test
    void run() {
        var input = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8\n" +
                "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3";
        Day15Ex1 solution = new Day15Ex1();
        solution.run(input);
    }
}