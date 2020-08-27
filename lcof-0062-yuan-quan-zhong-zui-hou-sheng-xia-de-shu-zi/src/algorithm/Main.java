package algorithm;

/** @author XueweiHuang */
public class Main {

  public static void main(String[] args) {

    int n = 5;
    int m = 2;
    System.out.println("n is " + n + ", " + "m is " + m);

    System.out.println("using recursive, result is " + lastRemainingWithRecursive(n, m));

    System.out.println("using iterative, result is " + lastRemainingWithIterative(n, m));

    System.out.println(
        "using circular linked list, result is " + lastRemainingWithCircularLinkedList(n, m));
  }

  /** f(n,m) = [f(n-1,m) + m] % n; f(0) = 0 */
  public static int lastRemainingWithRecursive(int n, int m) {

    if (n == 0) {
      return 0;
    }

    int pos = lastRemainingWithRecursive(n - 1, m);

    return (pos + m) % n;
  }

  /** f(n,m) = [f(n-1,m) + m] % n; f(0) = 0 */
  public static int lastRemainingWithIterative(int n, int m) {

    // 设 n 为 1 时， pos 的 index 为 0
    int pos = 0;

    for (int i = 2; i <= n; i++) {
      pos = (pos + m) % i;
    }

    return pos;
  }

  public static int lastRemainingWithCircularLinkedList(int n, int m) {

    Node pre = createCircularSinglyLinkedList(n);

    Node cur = pre.next;

    while (pre != cur) {
      for (int i = 1; i < m; i++) {
        cur = cur.next;
        pre = pre.next;
      }
      cur = cur.next;
      pre.next = cur;
    }

    return cur.value;
  }

  static class Node {

    int value;

    Node next;

    Node(int value) {
      this.value = value;
      next = null;
    }
  }

  public static Node createCircularSinglyLinkedList(int n) {

    Node head = new Node(0);

    Node cur = head;

    for (int i = 1; i < n; i++) {
      Node newNode = new Node(i);
      cur.next = newNode;
      cur = cur.next;
    }

    cur.next = head;

    return cur;
  }
}
