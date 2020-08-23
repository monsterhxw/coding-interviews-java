package algorithm;

/** @author XueweiHuang */
public class Main {

  public static void main(String[] args) {

    int n = 5;

    int m = 3;

    System.out.println(lastRemaining(n, m));
  }

  public static int lastRemaining(int n, int m) {

    int pos = 0;

    for (int i = 2; i <= n; i++) {
      pos = (pos + m) % i;
    }

    return pos;
  }
}
