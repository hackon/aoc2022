package no.hackon.aoc.twenty22;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

public class Day4Test {
  private static final String INPUT = """
      2-4,6-8
      2-3,4-5
      5-7,7-9
      2-8,3-7
      6-6,4-6
      2-6,4-8
      """;

  @Test
  void part1Sample() {
    var day = new Day4(INPUT);
    assertThat(day.solvePart1()).isEqualTo(2);
  }

  @Test
  void part1Actual() {
    var content = getDayInput("day4.txt");
    var day = new Day4(content);
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
    var day = new Day4(INPUT);
    assertThat(day.solvePart2()).isEqualTo(4);
  }

  @Test
  void part2Actual() {
    var content = getDayInput("day4.txt");
    var day = new Day4(content);
    System.out.println(day.solvePart2());
  }
}
