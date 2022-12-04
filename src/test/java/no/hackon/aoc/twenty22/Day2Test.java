package no.hackon.aoc.twenty22;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

public class Day2Test {
  private static final String INPUT = """
      A Y
      B X
      C Z
      """;

  /*
   * 3 * loss
   * 3 * draw
   * 3 * win
   */
  private static final String INPUT2 = """
      A X
      B X
      C X
      A Y
      B Y
      C Y
      A Z
      B Z
      C Z
      """;

  @Test
  void day2SamplesTest() {
    var day2 = new Day2(INPUT);
    assertThat(day2.solvePart1()).isEqualTo(15);
  }

  @Test
  void day1Actual() {
    var content = getDayInput("day2.txt");
    var day2 = new Day2(content);
    System.out.println(day2.solvePart1());
  }

  private String getDayInput(String fileName) {
    try {
      return Files.readString(new File(getClass().getClassLoader().getResource(fileName).toURI()).toPath());
    } catch (IOException e) {
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
    }
    return "";
  }

  @Test
  void day2Part2Sample() {
    var day2 = new Day2(INPUT);
    assertThat(day2.solvePart2()).isEqualTo(12);
  }

  @Test
  void day2Part2Sample2() {
    var day2 = new Day2(INPUT2);
    assertThat(day2.solvePart2()).isEqualTo(45);
  }

  @Test
  void day2Part2Actual() {
    var content = getDayInput("day2.txt");
    var day2 = new Day2(content);
    System.out.println(day2.solvePart2());
  }
}
