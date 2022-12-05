package no.hackon.aoc.twenty22;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

public class Day5Test {
  private static final String INPUT = """
          [D]
      [N] [C]
      [Z] [M] [P]
       1   2   3

      move 1 from 2 to 1
      move 3 from 1 to 3
      move 2 from 2 to 1
      move 1 from 1 to 2
      """;

  @Test
  void part1Sample() {
    var day = new Day5(INPUT);
    assertThat(day.solvePart1()).isEqualTo("CMZ");
  }

  @Test
  void part1Actual() {
    var content = getDayInput("day5.txt");
    var day = new Day5(content);
    System.out.println(day.solvePart1());
  }

  private String getDayInput(String fileName) {
    try {
      return Files.readString(new File(getClass().getClassLoader().getResource(fileName).toURI()).toPath());
    } catch (IOException | URISyntaxException e) {
    } // TODO Auto-generated catch block

    return "";
  }

  @Test
  void part2Sample() {
    var day = new Day5(INPUT);
    assertThat(day.solvePart2()).isEqualTo("MCD");
  }

  @Test
  void part2Actual() {
    var content = getDayInput("day5.txt");
    var day = new Day5(content);
    System.out.println(day.solvePart2());
  }
}
