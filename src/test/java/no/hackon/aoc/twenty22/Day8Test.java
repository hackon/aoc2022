package no.hackon.aoc.twenty22;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {
  private static final String INPUT = """
      30373
      25512
      65332
      33549
      35390
      """;

  @Test
  void part1Sample() {
    var day = new Day8(INPUT);
    assertThat(day.solvePart1()).isEqualTo(21);
  }


  @Test
  void part1Actual() {
    var content = Util.getDayInput("day8.txt");
    var day = new Day8(content);
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
    var day = new Day8(INPUT);
    assertThat(day.solvePart2()).isEqualTo(8);
  }

  @Test
  void part2Actual() {
    var content = getDayInput("day8.txt");
    var day = new Day8(content);
    System.out.println(day.solvePart2());
  }
}
