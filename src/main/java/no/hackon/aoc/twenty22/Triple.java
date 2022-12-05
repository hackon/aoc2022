package no.hackon.aoc.twenty22;

public class Triple {
  private final int s1;
  private final int s2;
  private final int s3;

  public static Triple of(int s1, int s2, int s3) {
    return new Triple(s1, s2, s3);
  }

  public Triple(int s1, int s2, int s3) {
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;
  }

  public int getS1() {
    return s1;
  }

  public int getS2() {
    return s2;
  }

  public int getS3() {
    return s3;
  }

}
