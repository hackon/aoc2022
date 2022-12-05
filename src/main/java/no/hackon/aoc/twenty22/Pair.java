package no.hackon.aoc.twenty22;

public class Pair<T1, T2> {

  private final T1 value1;
  private final T2 value2;

  public Pair(T1 value1, T2 value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  public static <T1, T2> Pair<T1, T2> of(T1 value1, T2 value2) {
    return new Pair<>(value1, value2);
  }

  //
  public T1 get1() {
    return value1;
  }

  public T2 get2() {
    return value2;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value1 == null) ? 0 : value1.hashCode());
    result = prime * result + ((value2 == null) ? 0 : value2.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    if (value1 == null) {
      if (other.value1 != null)
        return false;
    } else if (!value1.equals(other.value1))
      return false;
    if (value2 == null) {
      if (other.value2 != null)
        return false;
    } else if (!value2.equals(other.value2))
      return false;
    return true;
  }

}
