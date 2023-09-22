package fr.sma.aoc.adventofcode2015.solution.day10;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Day10Ex1 implements ExSolution {


    Logger logger = LoggerFactory.getLogger(Day10Ex1.class);

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"10", "1"});
    }

    @Override
    public String run(String input) {
        String result = input.trim();
        for (int i = 0; i < 40; i++) {
            result = transforms(result);
        }
        logger.info("" + result.length());
        return "" + result.length();
    }

    private String transforms(String result) {
        String ret = "";
        char prev = 'a';
        int count =0;
        for (var c : result.toCharArray()) {
            if(c != prev){
                if(count > 0){
                    ret += count + "" + prev;
                }
                prev = c;
                count =1;
            }
            else{
                count++;
            }
        }
        ret += count + "" + prev;
        return ret;
    }


}
