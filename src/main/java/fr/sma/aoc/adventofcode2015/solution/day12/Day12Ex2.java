package fr.sma.aoc.adventofcode2015.solution.day12;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Day12Ex2 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"12", "2"});
  }

  @Override
  public String run(String input) {
    return String.valueOf(traverse(new JSONObject(input).toMap()));
  }

  private int traverse(List<Object> list) {
    int count = 0;

    for (Object o : list) {
      if (o instanceof List<?>) {
        count += traverse((List<Object>) o);
      } else if (o instanceof Map<?, ?>) {
        count += traverse((Map<?, ?>) o);
      } else if (o instanceof Integer) {
        count += (int) o;
      }
    }

    return count;
  }

  private int traverse(Map<?, ?> map) {
    int count = 0;

    for (Object o : map.values()) {
      if (o instanceof List<?>) {
        count += traverse((List<Object>) o);
      } else if (o instanceof Map<?, ?>) {
        count += traverse((Map<?, ?>) o);
      } else if (o instanceof Integer) {
        count += (int) o;
      } else if (o instanceof String) {
        if (o.equals("red")) {
          return 0;
        }
      }
    }

    return count;
  }
}
