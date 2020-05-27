package 数据结构.栈;

public class Stack {
  public Node stackTop; // 栈顶
  public Node stackBottom; // 栈底

  public Stack() {}

  public Stack(Node stackTop, Node stackBottom) {
    this.stackTop = stackTop;
    this.stackBottom = stackBottom;
  }
}
