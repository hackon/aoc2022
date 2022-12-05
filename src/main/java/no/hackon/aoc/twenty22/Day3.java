package no.hackon.aoc.twenty22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class Day3 {

  private final String input;
  private final Map<Character, Integer> valueMap;

  public Day3(String input) {
    this.input = input;
    valueMap = new HashMap<>();
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    for (int i = 1; i <= alphabet.length; i++) {
      var c = alphabet[i - 1];
      valueMap.put(String.valueOf(c).toUpperCase().charAt(0), i + 26);
      valueMap.put(c, i);
    }

  }

  public int solvePart1() {
    return Stream.of(input.split("\n"))
        .map(this::splitDownTheMiddle)
        .peek(pair -> System.out.printf("%s AND %s%n", pair.get1(), pair.get2()))
        .map(this::getCommonChar)
        .peek(System.out::println)
        .map(this::toIntValue)
        .peek(System.out::println)
        .mapToInt(Integer::intValue)
        .sum();

  }

  private Pair<String, String> splitDownTheMiddle(String line) {
    if (line.length() % 2 != 0)
      throw new RuntimeException();
    var middleIdx = (line.length() / 2);
    var part1 = line.substring(0, middleIdx);
    var part2 = line.substring(middleIdx, line.length());
    return Pair.of(part1, part2);
  }

  private char getCommonChar(Pair<String, String> pair) {
    var charsNotInPart1 = findCommonElements(
        pair.get1().chars().mapToObj(e -> (char) e).toList(),
        pair.get2().chars().mapToObj(e -> (char) e).toList());

    return charsNotInPart1.iterator().next().charValue();
  }

  private static Set<Character> findCommonElements(List<Character>... lists) {
    Set<Character> common = new HashSet<>(lists[0]);
    for (int i = 1; i < lists.length; i++) {
      common.retainAll(lists[i]);
    }
    return common;
  }

  private int toIntValue(char c) {
    return valueMap.get(c);
  }

  public int solvePart2() {
    var lines = input.split("\n");
    var sum = 0;
    for (int i = 0; i < lines.length - 2; i = i + 3) {
      var common = findCommonElements(toCharList(lines[i]), toCharList(lines[i + 1]), toCharList(lines[i + 2]));
      var val = toIntValue(common.iterator().next());
      sum += val;
    }

    return sum;
  }

  private List<Character> toCharList(String string) {
    return string.chars().mapToObj(e -> (char) e).toList();
  }
}
