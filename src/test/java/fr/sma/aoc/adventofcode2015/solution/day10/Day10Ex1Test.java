package fr.sma.aoc.adventofcode2015.solution.day10;

import fr.sma.aoc.adventofcode2015.solution.day9.Day09Ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day10Ex1Test {

    @Test
    void run() {
        var input = "1113222113";
        Day10Ex1 solution = new Day10Ex1();
        solution.run(input);
    }
}