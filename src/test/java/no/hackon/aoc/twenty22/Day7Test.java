package no.hackon.aoc.twenty22;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {
  private static final String INPUT = """
      $ cd /
      $ ls
      dir a
      14848514 b.txt
      8504156 c.dat
      dir d
      $ cd a
      $ ls
      dir e
      29116 f
      2557 g
      62596 h.lst
      $ cd e
      $ ls
      584 i
      $ cd ..
      $ cd ..
      $ cd d
      $ ls
      4060174 j
      8033020 d.log
      5626152 d.ext
      7214296 k
      """;

  @Test
  void part1Sample() {
    var day = new Day7(INPUT);
    assertThat(day.solvePart1()).isEqualTo(95437);
  }


  @Test
  void part1Actual() {
    var content = getDayInput("day7.txt");
    var day = new Day7(content);
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
    var day = new Day7(INPUT);
    assertThat(day.solvePart2()).isEqualTo(24933642);
  }

  @Test
  void part2Actual() {
    var content = getDayInput("day7.txt");
    var day = new Day7(content);
    System.out.println(day.solvePart2());
  }
}
