package no.hackon.aoc.twenty22;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

public class Day3Test {
  private static final String INPUT = """
      vJrwpWtwJgWrhcsFMMfFFhFp
      jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
      PmmdzqPrVvPwwTWBwg
      wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
      ttgJtRGJQctTZtZT
      CrZsJsPPZsGzwwsLwLmpwMDw
      """;

  @Test
  void day3SamplesTest() {
    var day3 = new Day3(INPUT);
    assertThat(day3.solvePart1()).isEqualTo(157);
  }

  @Test
  void day3Actual() {
    var content = getDayInput("day3.txt");
    var day3 = new Day3(content);
    System.out.println(day3.solvePart1());
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
    var day = new Day3(INPUT);
    assertThat(day.solvePart2()).isEqualTo(70);
  }

  @Test
  void part2Actual() {
    var content = getDayInput("day3.txt");
    var day = new Day3(content);
    System.out.println(day.solvePart2());
  }
}
