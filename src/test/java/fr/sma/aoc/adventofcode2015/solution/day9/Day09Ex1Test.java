package fr.sma.aoc.adventofcode2015.solution.day9;

import fr.sma.aoc.adventofcode2015.solution.day08.Day08Ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day09Ex1Test {

    @Test
    void run() {
        var input = "Tristram to AlphaCentauri = 34\n" +
                "Tristram to Snowdin = 100\n" +
                "Tristram to Tambi = 63\n" +
                "Tristram to Faerun = 108\n" +
                "Tristram to Norrath = 111\n" +
                "Tristram to Straylight = 89\n" +
                "Tristram to Arbre = 132\n" +
                "AlphaCentauri to Snowdin = 4\n" +
                "AlphaCentauri to Tambi = 79\n" +
                "AlphaCentauri to Faerun = 44\n" +
                "AlphaCentauri to Norrath = 147\n" +
                "AlphaCentauri to Straylight = 133\n" +
                "AlphaCentauri to Arbre = 74\n" +
                "Snowdin to Tambi = 105\n" +
                "Snowdin to Faerun = 95\n" +
                "Snowdin to Norrath = 48\n" +
                "Snowdin to Straylight = 88\n" +
                "Snowdin to Arbre = 7\n" +
                "Tambi to Faerun = 68\n" +
                "Tambi to Norrath = 134\n" +
                "Tambi to Straylight = 107\n" +
                "Tambi to Arbre = 40\n" +
                "Faerun to Norrath = 11\n" +
                "Faerun to Straylight = 66\n" +
                "Faerun to Arbre = 144\n" +
                "Norrath to Straylight = 115\n" +
                "Norrath to Arbre = 135\n" +
                "Straylight to Arbre = 127";
        var input2 = "London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141";
        Day09Ex1 solution = new Day09Ex1();
        solution.run(input);
    }
}