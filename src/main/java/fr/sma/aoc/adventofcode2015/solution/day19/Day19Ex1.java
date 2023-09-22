package fr.sma.aoc.adventofcode2015.solution.day19;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Day19Ex1 implements ExSolution {

  private final int targetLiter;

  public Day19Ex1(int targetLiter) {
    this.targetLiter = targetLiter;
  }

  public Day19Ex1() {
    this(150);
  }

  public static void main(String[] args) {
    ResolveApplication.main(new String[] {"19", "1"});
  }

  public record MoleculePermutation(String source, String destination) {
  }

  @Override
  public String run(String input) {
    String[] allLines = input.split("\n");
    Set<MoleculePermutation> moleculePermutations = Arrays.stream(allLines)
      .filter(l -> l.contains("=>"))
      .map(l -> l.trim())
      .map(line -> new MoleculePermutation(line.split(" => ")[0], line.split(" => ")[1]))
      .collect(Collectors.toSet());

    String inputMolecule = allLines[allLines.length - 1];

    Set<String> newMolecules = new HashSet<>();
    for (MoleculePermutation moleculePermutation : moleculePermutations) {
      String sourceMolecule = moleculePermutation.source();
      String destinationMolecule = moleculePermutation.destination();

      int indexOfOccurence = inputMolecule.indexOf(sourceMolecule);
      while (indexOfOccurence != -1) {

        String s1 = inputMolecule.substring(0, indexOfOccurence);
        String newMolecule = s1 + inputMolecule.substring(indexOfOccurence).replaceFirst(sourceMolecule, destinationMolecule);

        newMolecules.add(newMolecule);
        if (indexOfOccurence + 1 <= inputMolecule.length()) {
          indexOfOccurence = inputMolecule.indexOf(sourceMolecule, indexOfOccurence + 1);
        }
      }
    }
    return newMolecules.size() + "";
  }

  private Set<Set<Container>> findCombinations(Set<Container> remainingJars, int remainingVolume, Set<Container> currentlyFilled) {
    if (remainingVolume == 0) {
      return Set.of(Set.copyOf(currentlyFilled));
    }

    Set<Set<Container>> matchingCombination = new HashSet<>();
    for (Container jar : remainingJars) {
      if (remainingVolume < jar.volume) {
        continue;
      }
      var nextRemainings = new HashSet<>(remainingJars);
      nextRemainings.remove(jar);
      var nextFilled = new HashSet<>(currentlyFilled);
      nextFilled.add(jar);
      matchingCombination.addAll(
        findCombinations(nextRemainings, remainingVolume - jar.volume, nextFilled)
      );
    }
    return matchingCombination;
  }

  public record Container(int id, int volume) {
  }
}
