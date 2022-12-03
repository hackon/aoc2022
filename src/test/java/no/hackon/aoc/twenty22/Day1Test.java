package no.hackon.aoc.twenty22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class Day1Test {

  private static final String INPUT = """
      1000
      2000
      3000

      4000

      5000
      6000

      7000
      8000
      9000

      10000
      """;

  @Test
  void day1SamplesTest() {
    var day1 = new Day1(INPUT);
    assertThat(day1.solvePart1()).isEqualTo(24000);
  }

  @Test
  void day1Actual() {
    var content = getDayInput("day1.txt");
    var day1 = new Day1(content);
    System.out.println(day1.solvePart1());
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
  void day1Part2Sample() {
    var day1 = new Day1(INPUT);
    assertThat(day1.solvePart2()).isEqualTo(45000);

  }

  @Test
  void day1Part2Actual() throws IOException, URISyntaxException {
    var content = getDayInput("day1.txt");
    var day1 = new Day1(content);
    System.out.println(day1.solvePart2());

  }
}
