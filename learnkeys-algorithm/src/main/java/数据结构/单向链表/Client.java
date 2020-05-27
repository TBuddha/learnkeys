package 数据结构.单向链表;

public class Client {
  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    // 添加链表结点
    myLinkedList.addNode(9);
    myLinkedList.addNode(8);
    myLinkedList.addNode(6);
    myLinkedList.addNode(3);
    myLinkedList.addNode(5);

    // 插入节点
    myLinkedList.insertNode(1, 88);

    // 打印链表
    myLinkedList.printLink();

    /*//测试链表结点个数
    System.out.println("链表结点个数为：" + myLinkedList.length());

    //链表排序
    Node head = myLinkedList.linkSort();
    System.out.println("排序后的头结点为：" + head.data);
    myLinkedList.printLink();

    //去除重复结点
    myLinkedList.distinctLink();
    myLinkedList.printLink();

    //链表反转
    myLinkedList.reserveLink();
    myLinkedList.printLink();

    //倒序输出/遍历链表
    myLinkedList.reservePrt(myLinkedList.head);

    //返回链表的中间结点
    Node middleNode = myLinkedList.findMiddleNode();
    System.out.println("中间结点的数值为："+middleNode.data);

    //判断链表是否有环
    boolean isRinged = myLinkedList.isRinged();
    System.out.println("链表是否有环：" + isRinged);
    //将链表的最后一个结点指向头结点，制造有环的效果
    Node lastNode = myLinkedList.getLastNode();
    lastNode.next = myLinkedList.head;
    isRinged = myLinkedList.isRinged();
    System.out.println("链表是否有环：" + isRinged);

    //删除指定结点
    Node nk = myLinkedList.findReverNode(3);
    System.out.println(nk.data);
    myLinkedList.deleteSpecialNode(nk);
    myLinkedList.printLink();

    //链表是否相交
    //新链表
    MyLinkedList myLinkedList1 = new MyLinkedList();
    myLinkedList1.addNode(构建器);
    myLinkedList1.addNode(2);
    myLinkedList1.printLink();
    System.out.println("链表一和链表二是否相交"+myLinkedList.isCross(myLinkedList.head, myLinkedList1.head));
    //把第二个链表从第三个结点开始接在第二个链表的后面，制造相交的效果
    myLinkedList1.findNode(2).next = myLinkedList.findNode(3);
    myLinkedList1.printLink();
    System.out.println("链表一和链表二是否相交"+myLinkedList.isCross(myLinkedList.head, myLinkedList1.head));
    */

    // 如果两个链表相交求链表相交的结点的值
    /*MyLinkedList myLinkedList1 = new MyLinkedList();
    myLinkedList1.addNode(构建器);
    myLinkedList1.addNode(2);
    myLinkedList1.findNode(2).next = myLinkedList.findNode(3);
    myLinkedList1.printLink();
    Node n = myLinkedList1.findFirstCrossPoint(myLinkedList, myLinkedList1);
    if (n == null) {
        System.out.println("链表不相交");
    } else {
        System.out.println("两个链表相交，第一个交点的数值为：" + n.data);
    }*/
  }
}
