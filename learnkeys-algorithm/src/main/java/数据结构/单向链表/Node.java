package 数据结构.单向链表;

public class Node {
  // 数据域
  public int data;

  // 指针域，指向下一个节点
  public Node next = null;

  public Node() {}

  public Node(int data) {
    this.data = data;
  }

  public Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }
}
