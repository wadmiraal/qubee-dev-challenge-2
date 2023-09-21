package fr.sma.aoc.adventofcode2015.solution.day02;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Day02Ex2 implements ExSolution {

    Logger logger = LoggerFactory.getLogger(Day03Ex1.class);

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"02", "2"});
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
        return "" + result;
    }

    private long getPaper(String s, String s1, String s2) {
        int l = Integer.parseInt(s);
        int w = Integer.parseInt(s1);
        int h = Integer.parseInt(s2);
        long result = 0;
        result += h*l*w;
        int big = Math.max(l, h);
        big = Math.max(big, w);
        result += 2*(l+w+h) - 2*big;
        return result;
    }
}
