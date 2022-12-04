package no.hackon.aoc.twenty22;

import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class Day2 {

  private String input;

  public Day2(String input) {
    this.input = input;

    /*
     * A Rock
     * B Paper
     * C Scissors
     * 
     * X Rock
     * Y Paper
     * Z Scissors
     */
  }

  public int solvePart1() {
    return Stream.of(input.split("\n"))
        .map(this::toHands)
        .map(this::fight)
        .mapToInt(Integer::intValue)
        .sum();
  }

  private int fight(Character[] hands) {
    var opponentChoice = hands[0];
    var ourChoice = hands[1];
    var ourScore = ourChoiceToPoints(ourChoice) + ourOutcome(ourChoice, opponentChoice);

    System.out.printf("Our: %s vs %s. Score %d%n", ourChoice, opponentChoice, ourScore);
    return ourScore;
  }

  private int ourOutcome(Character ourChoice, Character opponentChoice) {
    if ('X' == ourChoice && 'C' == opponentChoice)
      return 6;
    if ('X' == ourChoice && 'B' == opponentChoice)
      return 0;
    if ('X' == ourChoice && 'A' == opponentChoice)
      return 3;
    if ('Y' == ourChoice && 'A' == opponentChoice)
      return 6;
    if ('Y' == ourChoice && 'C' == opponentChoice)
      return 0;
    if ('Y' == ourChoice && 'B' == opponentChoice)
      return 3;
    if ('Z' == ourChoice && 'B' == opponentChoice)
      return 6;
    if ('Z' == ourChoice && 'A' == opponentChoice)
      return 0;
    if ('Z' == ourChoice && 'C' == opponentChoice)
      return 3;
    return 0;
  }

  private int ourChoiceToPoints(Character ourChoice) {
    return switch (ourChoice) {
      case 'X':
        yield 1;
      case 'Y':
        yield 2;
      case 'Z':
        yield 3;
      default:
        yield 0;
    };
  }

  public int solvePart2() {
    return Stream.of(input.split("\n"))
        .map(this::toHands)
        .map(this::remapHands)
        .map(this::fight)
        .mapToInt(Integer::intValue)
        .sum();
  }

  private Character[] toHands(String string1) {
    var split = string1.split(" ");
    var opponentChoice = split[0].charAt(0);
    var ourChoice = split[1].charAt(0);
    return new Character[] { opponentChoice, ourChoice };
  }

  private Character[] remapHands(Character[] hands) {
    var opponentChoice = hands[0];
    var ourChoice = hands[1];
    var oldChoice = ourChoice;
    if ('X' == ourChoice) {
      // lose
      ourChoice = switch (opponentChoice) {
        case 'A':
          yield 'Z';
        case 'B':
          yield 'X';
        case 'C':
          yield 'Y';
        default:
          yield 'Ø';
      };
    } else if ('Y' == ourChoice) {
      // Draw
      ourChoice = switch (opponentChoice) {
        case 'A':
          yield 'X';
        case 'B':
          yield 'Y';
        case 'C':
          yield 'Z';
        default:
          yield 'Ø';
      };
    } else if ('Z' == ourChoice) {
      // Win
      ourChoice = switch (opponentChoice) {
        case 'A':
          yield 'Y';
        case 'B':
          yield 'Z';
        case 'C':
          yield 'X';
        default:
          yield 'Ø';
      };
    }
    System.out.printf("Old: %s vs new: %s%n", oldChoice, ourChoice);
    return new Character[] { opponentChoice, ourChoice };
  }

}
