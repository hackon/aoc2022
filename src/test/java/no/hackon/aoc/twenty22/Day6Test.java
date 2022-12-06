package no.hackon.aoc.twenty22;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;

public class Day6Test {
  private static final String INPUT = """

      """;

  @Test
  void part1Sample() {
    var day = new Day6("bvwbjplbgvbhsrlpgdmjqwftvncz");
    assertThat(day.solvePart1()).isEqualTo(5);
  }

  @Test
  void part1Sample2() {
    var day = new Day6("nppdvjthqldpwncqszvftbrmjlhg");
    assertThat(day.solvePart1()).isEqualTo(6);
  }

  @Test
  void part1Sample3() {
    var day = new Day6("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
    assertThat(day.solvePart1()).isEqualTo(10);
  }

  @Test
  void part1Sample4() {
    var day = new Day6("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
    assertThat(day.solvePart1()).isEqualTo(11);
  }

  @Test
  void part1Actual() {
    var content = getDayInput("day6.txt");
    var day = new Day6(content);
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
    var day = new Day6("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
    assertThat(day.solvePart2()).isEqualTo(19);
  }

  @Test
  void part2Sample1() {
    var day = new Day6("bvwbjplbgvbhsrlpgdmjqwftvncz");
    assertThat(day.solvePart2()).isEqualTo(23);
  }

  @Test
  void part2Sample2() {
    var day = new Day6("nppdvjthqldpwncqszvftbrmjlhg");
    assertThat(day.solvePart2()).isEqualTo(23);
  }

  @Test
  void part2Sample3() {
    var day = new Day6("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
    assertThat(day.solvePart2()).isEqualTo(29);
  }

  @Test
  void part2Sample4() {
    var day = new Day6("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
    assertThat(day.solvePart2()).isEqualTo(26);
  }

  @Test
  void part2Actual() {
    var content = getDayInput("day6.txt");
    var day = new Day6(content);
    System.out.println(day.solvePart2());
  }
}
