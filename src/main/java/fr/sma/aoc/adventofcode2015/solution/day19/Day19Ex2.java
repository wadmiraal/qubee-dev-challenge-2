package fr.sma.aoc.adventofcode2015.solution.day19;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class Day19Ex2 implements ExSolution {

    static List<Transformation> trans = new ArrayList<>();

    record Transformation(String source, String target) {
    }

    static Map<String, Integer> seen = new HashMap<>();

    static String goal;

    static int minStep = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"19", "2"});
    }

    @Override
    public String run(String input) {
        var lines = input.split("\n");
        goal = lines[lines.length - 1].trim();

        for (int i = 0; i < lines.length - 2; i++) {
            var groups = lines[i].split("=>");
            trans.add(new Transformation(groups[1].trim(), groups[0].trim()));
        }

        Collections.sort(trans, (a, b) -> b.source.length() - a.source.length());

        find(goal, 0);

        return "" + minStep;
    }


    void find(String origin, int step) {
        if (origin.equals("e")) {
            System.out.println("" + step);
            minStep = Math.min(minStep, step);
        }
        if (step >= minStep) {
            return;
        }
        if (seen.getOrDefault(origin, Integer.MAX_VALUE) <= step) {
            return;
        }
        seen.put(origin, step);
        for (var tran : trans) {
            if (tran.target.equals("e") && origin.length() > 3) {
                continue;
            }
            int index = origin.indexOf(tran.source, 0);
            while (index != -1) {
                String newMole = origin.substring(0, index) + origin.substring(index).replaceFirst(tran.source, tran.target);
                find(newMole, step + 1);
                if (index + 1 >= origin.length()) {
                    break;
                }
                index = origin.indexOf(tran.source, index + 1);
            }
        }

    }


}
