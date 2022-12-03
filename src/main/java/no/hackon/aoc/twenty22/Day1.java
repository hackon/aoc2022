package no.hackon.aoc.twenty22;

import java.util.stream.Stream;

public class Day1 {

  private String input;

  public Day1(String input) {
    this.input = input;
  }

  public int solvePart1() {
    return extracted()
        .max(Integer::compareTo)
        .orElse(0);
  }

  private Stream<Integer> extracted() {
    return Stream.of(input.split("\n\n"))
        .map(loadsForOneElf -> Stream.of(loadsForOneElf.split("\n")).mapToInt(Integer::parseInt).sum());
  }

  public int solvePart2() {
    return extracted()
        .sorted((o1, o2) -> o2.compareTo(o1))
        .limit(3)
        .mapToInt(Integer::intValue)
        .sum();
  }

}
