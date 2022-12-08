package no.hackon.aoc.twenty22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Day7 {
  private final String input;

  public Day7(String input) {
    this.input = input;
  }

  private static String changeDir(String folder, String line) {
    String path = line.split(" ")[2];
    var currentFolders = new ArrayList<>(Arrays.stream(folder.split("_")).toList());
    if (Objects.equals(path, "..") && currentFolders.size() != 1) {
      currentFolders.remove(currentFolders.size() - 1);
    } else  {
      currentFolders.add(path);
    }
    return String.join("_", currentFolders);
  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  public int solvePart1() {
    Map<String, Integer> folders = getFolderSizes();
    return folders.values().stream()
        .filter(size -> size < 100_000)
        .mapToInt(Integer::intValue)
        .sum();

  }

  private Map<String, Integer> getFolderSizes() {
    List<String> lines = input.lines().toList();
    Map<String, Integer> folders = new HashMap<>();
    var folder = "";
    for (var line : lines) {
      if (line.startsWith("$ cd")) {
        folder = changeDir(folder, line);
      } else if (isNumeric(line.split(" ")[0])) {
        var tmpFolder = folder;
        var size = Integer.parseInt(line.split(" ")[0]);
        do {
          folders.compute(tmpFolder, (key, oldValue) -> oldValue == null ? size : oldValue + size);
          tmpFolder = changeDir(tmpFolder, "$ cd ..");
        } while (!tmpFolder.equals(""));
      }
      System.out.println(folder);
    }
    return folders;
  }

  public int solvePart2() {
    Map<String, Integer> folderSizes = getFolderSizes();
    Integer totalUsed = folderSizes.get("_/");
    int totalUnused = 70_000_000 - totalUsed;
    int minToFree = 30_000_000 - totalUnused;
    return folderSizes.values().stream().sorted().filter(size -> size > minToFree).findFirst().get();

//    return 0;
  }
}
