package no.hackon.aoc.twenty22;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {

  private String input;

  public Day5(String input) {
    this.input = input;
  }
  // private static final String INPUT = """
  // [D]
  // [N] [C]
  // [Z] [M] [P]
  // 1 2 3

  // TRANSFORM TO
  // Z N
  // M C D
  // P

  // move 1 from 2 to 1
  // move 3 from 1 to 3
  // move 2 from 2 to 1
  // move 1 from 1 to 2
  // """;

  public String solvePart1() {
    var inputs = input.split("\n\n");
    var stacksLines = inputs[0];
    var instructionsLines = inputs[1];

    var stack = toStack(stacksLines);
    var instructions = toInstructions(instructionsLines);

    var newStack = moveStack(stack, instructions);
    return newStack.stream().map(q -> String.valueOf(q.pop())).collect(Collectors.joining());
  }

  private List<Deque<Character>> moveStack(List<Deque<Character>> stack, List<Triple> instructions) {
    for (Triple instruction : instructions) {
      var moveCount = instruction.getS1();
      var fromCol = instruction.getS2();
      var toCol = instruction.getS3();
      for (int i = 0; i < moveCount; i++) {
        var popVal = stack.get(fromCol - 1).pop();
        stack.get(toCol - 1).addFirst(popVal);
      }
    }
    return stack;
  }

  private List<Deque<Character>> moveStack2(List<Deque<Character>> stack, List<Triple> instructions) {
    for (Triple instruction : instructions) {
      var moveCount = instruction.getS1();
      var fromCol = instruction.getS2();
      var toCol = instruction.getS3();
      var tmpList = new ArrayDeque<Character>();
      for (int i = 0; i < moveCount; i++) {
        tmpList.addFirst(stack.get(fromCol - 1).pop());
      }
      for (int i = 0; i < moveCount; i++) {
        stack.get(toCol - 1).addFirst(tmpList.pop());
      }

      // for (int i = 0; i < moveCount; i++) {
      // var popVal = stack.get(fromCol - 1).pop();
      // stack.get(toCol - 1).addFirst(popVal);
      // }
    }
    return stack;
  }

  private List<Triple> toInstructions(String instructionsLines) {
    return instructionsLines.lines()
        .map(line -> line.split(" "))
        .map(lineArr -> extracted(lineArr))
        .toList();
  }

  private Triple extracted(String[] lineArr) {
    return Triple.of(Integer.valueOf(lineArr[1]), Integer.valueOf(lineArr[3]), Integer.valueOf(lineArr[5]));
  }

  private List<Deque<Character>> toStack(String stacksLines) {
    var lines = new ArrayList<>(stacksLines.lines().toList());
    var lastLineWithColumns = lines.remove(lines.size() - 1);
    var res = new ArrayList<Deque<Character>>();
    for (int l = 0; l < lines.size(); l++) {
      for (int i = 1; i < lastLineWithColumns.length(); i = i + 4) {
        int index = Integer.parseInt(String.valueOf(lastLineWithColumns.charAt(i)));
        if (res.size() < index && l == 0) {
          res.add(new ArrayDeque<>());
        }
        var q = res.get(index - 1);
        String line = lines.get(l);
        if (line.length() > i) {
          if (line.charAt(i) != ' ') {

            q.add(line.charAt(i));
          }
        }
      }

    }
    return res;

    // var stacks = new ArrayList<>();
    // var r = Pattern.compile("\\[(.)");
    // var dr= Pattern.compile("(\\d)");
    // // [D] [W] [W] [F] [T] [H] [Z] [W] [R]
    // var lines = stacksLines.lines().toList();
    // var lastLineWithColumns = lines.remove(lines.size() - 1);
    // var nrOfColumns = dr.matcher(lastLineWithColumns).groupCount();
    // var rotatedStacks = new char[lines.size()][nrOfColumns];

    // // Collections.reverse(lines)
    // // lines.stream().sequential()
    // // .filter(l->l.startsWith("["))
    // // .map(l->{
    // // var matches = r.matcher(l);
    // // var groupCount = matches.groupCount()
    // // for (int i = 0; i < groupCount; i++) {
    // // var group = matches.group(i);
    // // }

    // // })
    // // return null;
  }

  public String solvePart2() {
    var inputs = input.split("\n\n");
    var stacksLines = inputs[0];
    var instructionsLines = inputs[1];

    var stack = toStack(stacksLines);
    var instructions = toInstructions(instructionsLines);

    var newStack = moveStack2(stack, instructions);
    return newStack.stream().map(q -> String.valueOf(q.pop())).collect(Collectors.joining());
  }

}
