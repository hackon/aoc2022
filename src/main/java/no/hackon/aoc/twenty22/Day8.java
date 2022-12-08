package no.hackon.aoc.twenty22;

import java.util.List;

public class Day8 {
  private final String input;

  public Day8(String input) {
    this.input = input;
  }

  public int solvePart1() {
    var grid = input.lines().toList();
    var lineLength = grid.get(0).length();
    var sum = 0;
    var visible = false;
    for (int lineIndex = 1; lineIndex < grid.size() - 1; lineIndex++) {
      for (int colIndex = 1; colIndex < lineLength - 1; colIndex++) {
        char treeHeight = grid.get(lineIndex).charAt(colIndex);
        visible = checkUp(grid, lineIndex, colIndex, treeHeight) ||
            checkDown(grid, lineIndex, colIndex, treeHeight) ||
            checkLeft(grid, lineIndex, colIndex, treeHeight) ||
            checkRight(grid, lineIndex, colIndex, treeHeight);
        if (visible) {
          sum += 1;
        }
      }
    }

    return sum + (grid.size() * 2) + (lineLength * 2) - 4;
  }

  private boolean checkRight(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    var lineWidth = grid.get(0).length();
    for (int i = colIndex + 1; i < lineWidth; i++) {
      var heightAt = grid.get(lineIndex).charAt(i);
      if (heightAt >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  private boolean checkLeft(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    for (int i = colIndex - 1; i >= 0; i--) {
      var heightAt = grid.get(lineIndex).charAt(i);
      if (heightAt >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  private boolean checkDown(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    for (int i = lineIndex + 1; i < grid.size(); i++) {
      var heightAt = grid.get(i).charAt(colIndex);
      if (heightAt >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  private boolean checkUp(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    for (int i = lineIndex - 1; i >= 0; i--) {
      var heightAt = grid.get(i).charAt(colIndex);
      if (heightAt >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  public int solvePart2() {
    var grid = input.lines().toList();
    var lineLength = grid.get(0).length();
    var bestScenicScore = 0;
    for (int lineIndex = 1; lineIndex < grid.size() - 1; lineIndex++) {
      for (int colIndex = 1; colIndex < lineLength - 1; colIndex++) {
        char treeHeight = grid.get(lineIndex).charAt(colIndex);
        var scenicScore = score(grid, lineIndex, colIndex, treeHeight);
        if (scenicScore > bestScenicScore) {
          bestScenicScore = scenicScore;
        }
      }
    }
    return bestScenicScore;
  }

  private int score(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    int up = countUp(grid, lineIndex, colIndex, treeHeight);
    int down = countDown(grid, lineIndex, colIndex, treeHeight);
    int left = countLeft(grid, lineIndex, colIndex, treeHeight);
    int right = countRight(grid, lineIndex, colIndex, treeHeight);
    return up *
        down *
        left *
        right;

  }

  private int countRight(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    var lineWidth = grid.get(0).length();
    for (int i = colIndex + 1; i < lineWidth; i++) {
      var heightAt = grid.get(lineIndex).charAt(i);
      if (heightAt >= treeHeight) {
        return i - colIndex;
      }
    }
    return lineWidth - (colIndex + 1);
  }

  private int countLeft(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    for (int i = colIndex - 1; i >= 0; i--) {
      var heightAt = grid.get(lineIndex).charAt(i);
      if (heightAt >= treeHeight) {
        return colIndex - i;
      }
    }
    return colIndex;
  }

  private int countDown(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    for (int i = lineIndex + 1; i < grid.size(); i++) {
      var heightAt = grid.get(i).charAt(colIndex);
      if (heightAt >= treeHeight) {
        return i - lineIndex;
      }
    }
    return grid.size() - (lineIndex + 1);
  }

  private int countUp(List<String> grid, int lineIndex, int colIndex, char treeHeight) {
    for (int i = lineIndex - 1; i >= 0; i--) {
      var heightAt = grid.get(i).charAt(colIndex);
      if (heightAt >= treeHeight) {
        return lineIndex - i;
      }
    }
    return lineIndex;
  }
}
