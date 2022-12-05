package no.hackon.aoc.twenty22;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class Day4 {

  private String input;

  public Day4(String input) {
    this.input = input;
  }

  public long solvePart1() {
    return input.lines()
        .map(line -> line.split(","))
        .filter(assigns -> checkIfAssignedDouble(assigns[0], assigns[1]))
        .count();
  }

  private boolean checkIfAssignedDouble(String assign1, String assign2) {

    var assSplit1 = Arrays.stream(assign1.split("-")).mapToInt(Integer::parseInt).toArray();
    var assSplit2 = Arrays.stream(assign2.split("-")).mapToInt(Integer::parseInt).toArray();
    return (assSplit1[0] <= assSplit2[0] && assSplit1[1] >= assSplit2[1])
        || (assSplit2[0] <= assSplit1[0] && assSplit2[1] >= assSplit1[1]);

  }

  public long solvePart2() {
    return input.lines()
        .map(line -> line.split(","))
        .filter(
            assigns -> checkIfAssignedOverlap(assigns[0], assigns[1]) || checkIfAssignedOverlap(assigns[1], assigns[0]))
        .count();
  }

  private boolean checkIfAssignedOverlap(String assign1, String assign2) {
    var assSplit1 = Arrays.stream(assign1.split("-")).mapToInt(Integer::parseInt).toArray();
    var assSplit2 = Arrays.stream(assign2.split("-")).mapToInt(Integer::parseInt).toArray();
    // 2-4, 6-8: 2 >= 6 && 2 <= 8 || 4 >= 6 && 4 <= 8
    // 2-8, 3-7: 2 >= 3 && 5 <= 7 || 7 >= 7 && 7 <= 9
    boolean isAss1InRange = assSplit1[0] >= assSplit2[0] && assSplit1[0] <= assSplit2[1];
    boolean isAss2InRange = assSplit1[1] >= assSplit2[0] && assSplit1[1] <= assSplit2[1];
    boolean isInRange = isAss1InRange || isAss2InRange;
    if (isInRange) {
      System.out.printf("%s %s%n", assign1, assign2);
    }
    return isInRange;
  }

}
