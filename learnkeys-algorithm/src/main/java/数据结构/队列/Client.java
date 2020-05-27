package 数据结构.队列;

public class Client {

  /**
   * 判断队列是否满了，front和rear指针紧挨着，就是满了
   *
   * @param queue
   * @return
   */
  public static boolean isFull(Queue queue) {
    if ((queue.rear + 1) % queue.arrays.length == queue.front) {

      System.out.println("--->此时队列满了！");
      return true;
    } else {
      System.out.println("--->此时队列没满！");
      return false;
    }
  }

  /**
   * 入队
   *
   * @param queue
   */
  public static void enQueue(Queue queue, int value) {
    // 不是满的队列才能入队
    if (!isFull(queue)) {

      // 将新的元素插入到队尾中
      queue.arrays[queue.rear] = value;

      // rear节点移动到新的无效元素位置上
      queue.rear = (queue.rear + 1) % queue.arrays.length;
    }
  }

  /**
   * 遍历队列
   *
   * @param queue
   */
  public static void traverseQueue(Queue queue) {

    // front的位置
    int i = queue.front;

    while (i != queue.rear) {

      System.out.println("遍历结果--->" + queue.arrays[i]);

      // 移动front
      i = (i + 1) % queue.arrays.length;
    }
  }

  /**
   * 判断队列是否空，front和rear指针相等，就是空了
   *
   * @param queue
   * @return
   */
  public static boolean isEmpty(Queue queue) {
    if (queue.rear == queue.front) {
      System.out.println("--->此时队列为空！");
      return true;
    } else {
      System.out.println("--->此时队列非空！");
      return false;
    }
  }

  /**
   * 出队
   *
   * @param queue
   */
  public static void outQueue(Queue queue) {
    // 判断该队列是否为null
    if (!isEmpty(queue)) {
      // 不为空才出队
      int value = queue.arrays[queue.front];
      System.out.println("--->出队的元素是：" + value);

      // front指针往后面移
      queue.front = (queue.front + 1) % queue.arrays.length;
    }
  }

  public static void main(String[] args) {
    // 初始化队列
    Queue queue = new Queue();

    queue.front = 0;
    queue.rear = 0;
    queue.arrays = new int[6];

    // 入队
    enQueue(queue, 3);
    enQueue(queue, 1);
    enQueue(queue, 2);
    enQueue(queue, 4);
    enQueue(queue, 6);
    // 队列已满了就插入不了了(验证上面的方法是否正确)：
    enQueue(queue, 5);

    // 遍历队列
    traverseQueue(queue);

    outQueue(queue);
    outQueue(queue);
    outQueue(queue);
    outQueue(queue);
    outQueue(queue);
    outQueue(queue);
  }
}
