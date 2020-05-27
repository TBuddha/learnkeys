package io.nio;

import java.nio.CharBuffer;

/**
 * @author zhouT
 * @date 2018/12/26 18:43
 */
public class BufferTest {
  public static void main(String[] args) {
    // 创建buffer
    CharBuffer buff = CharBuffer.allocate(8);
    System.out.println("capacity:" + buff.capacity());
    System.out.println("limit:" + buff.limit());
    System.out.println("position:" + buff.position());
    // 放入元素
    buff.put("a");
    buff.put("b");
    buff.put("c");
    System.out.println("加入三个元素后position：" + buff.position());
    // 将limit(界限)设置到position所在位置
    buff.flip();
    System.out.println("执行flip后limit:" + buff.limit());
    System.out.println("执行flip后capacity:" + buff.capacity());

    // 取出第一个元素
    System.out.println("第一个元素(position=0):" + buff.get());
    System.out.println("取出第一个元素，position：" + buff.position());

    buff.clear();
    System.out.println("执行clear后，limit=" + buff.limit());
    System.out.println("执行clear后，position=" + buff.position());

    System.out.println("执行clear后,缓冲区内容并没有被消除，第三个元素为：" + buff.get(2));
    System.out.println("执行绝对读取后，position:" + buff.position());
  }
}
