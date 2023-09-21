package fr.sma.aoc.adventofcode2015.solution.day08;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Day08Ex1 implements ExSolution {


    Logger logger = LoggerFactory.getLogger(Day03Ex1.class);

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"08", "1"});
    }

    @Override
    public String run(String input) {
        var lines = input.split("\n");
        long result = 0;
        for (var line : lines) {
            result += count(line.trim());

        }
        logger.info("" + result);
        return "" + result;
    }

    private long count(String line) {
        int ret = 0;
        int len1 = line.length();
        String line2 = line.replace("\\\\", "");
        int len2 = line2.length();
        ret += (len1-len2)/2;
        int len3 = line2.replace("\\\"", "").length();
        ret += (len2-len3)/2;
        int len4 = line2.replace("\\x", "").length();
        ret += (len2-len4) * 3 / 2;
        ret += 2;
        return ret;

    }

}
