package fr.sma.aoc.adventofcode2015.solution.day9;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import fr.sma.aoc.adventofcode2015.solution.day03.Day03Ex1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Component
public class Day09Ex1 implements ExSolution {
    static Map<String, Map<String, Integer>> grid = new HashMap<>();


    Logger logger = LoggerFactory.getLogger(Day03Ex1.class);

    public static void main(String[] args) {
        ResolveApplication.main(new String[]{"09", "1"});
    }

    @Override
    public String run(String input) {
        var lines = input.split("\n");
        for (var line : lines) {
            parse(line.trim());
        }
        int result = Integer.MAX_VALUE;
        for (var start : grid.keySet()) {
            result = Math.min(result, findPath(start));
        }
        logger.info("" + result);
        return "" + result;
    }

    private int findPath(String start) {
        Set<String> visited = new HashSet<>();
        var current = start;
        int ret = 0;

        visited.add(current);
        while (visited.size() < grid.size()) {
            String next = findSmallest(current, visited);
            ret += grid.get(current).get(next);
            current = next;
            visited.add(current);
        }
        return ret;
    }

    private String findSmallest(String current, Set<String> visited) {
        String ret = "";
        int dis = Integer.MAX_VALUE;
        var cities = grid.get(current);
        for (var entry : cities.entrySet()) {
            if (!visited.contains(entry.getKey()) && entry.getValue() < dis) {
                dis = entry.getValue();
                ret = entry.getKey();
            }
        }
        return ret;
    }


    private void parse(String line) {
        String[] group = line.split("=");
        int distance = Integer.parseInt(group[1].trim());
        String[] cities = group[0].split("to");
        String a = cities[0].trim();
        String b = cities[1].trim();
        grid.computeIfAbsent(a, k -> new HashMap<>());
        grid.computeIfAbsent(b, k -> new HashMap<>());
        grid.get(a).put(b, distance);
        grid.get(b).put(a, distance);
    }


}
