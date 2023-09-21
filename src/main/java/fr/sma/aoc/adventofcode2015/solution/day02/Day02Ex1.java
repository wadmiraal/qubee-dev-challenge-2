package fr.sma.aoc.adventofcode2015.solution.day02;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day02Ex1 implements ExSolution {

    Logger logger = LoggerFactory.getLogger(Day03Ex1.class);

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"02", "1"});
    }

    @Override
    public String run(String input) {
        var lines = input.split("\n");
        long result = 0;
        for (var line : lines) {
            var d = line.split("x");
            result += getPaper(d[0], d[1], d[2]);
        }
        logger.info("" + result);
        return "";
    }

    private long getPaper(String s, String s1, String s2) {
        int l = Integer.parseInt(s);
        int w = Integer.parseInt(s1);
        int h = Integer.parseInt(s2);
        long result = 0;
        result += 2*l*w;
        result += 2*l*h;
        result += 2*w*h;
        int small = Math.min(l*w, l*h);
        small = Math.min(small, w*h);
        result += small;
        return result;
    }
}
