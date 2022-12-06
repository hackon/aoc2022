package no.hackon.aoc.twenty22;

public class Day6 {

  private String input;

  public Day6(String input) {
    this.input = input;
  }

  public int solvePart1() {
    int keyLength = 4;
    return getUniqueIndex(keyLength);
  }

  private int getUniqueIndex(int keyLength) {
    for (int i = keyLength; i < input.length(); i++) {
      if (allUniqueChars(input.substring(i - keyLength, i))) {
        return i;
      }
    }
    return 0;
  }

  private boolean allUniqueChars(String input) {
    for (int i = 0; i < input.length(); i++) {
      char charcterofinputstring = input.charAt(i);
      int count = 0;
      for (int j = i; j < input.length(); j++) {
        if (charcterofinputstring == input.charAt(j))
          count++;
      }
      if (count > 1)
        return false;
    }
    return true;

  }

  public int solvePart2() {
    return getUniqueIndex(14);
  }

}
