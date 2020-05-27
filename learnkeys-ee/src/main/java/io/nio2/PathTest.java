package io.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zhouT
 * @date 2018/12/27 15:00
 */
public class PathTest {
  public static void main(String[] args) {
    // 以当前路径来创建path对象
    Path path = Paths.get(".");
    System.out.println("path里包含的路径数量：" + path.getNameCount());
    System.out.println("path的根路径：" + path.getRoot());
    // 获取path的对应的绝对路径
    Path absolutePath = path.toAbsolutePath();
    System.out.println(absolutePath);
    // 获取绝对路径的根路径
    System.out.println(absolutePath.getRoot());
    // 获取绝对路径包含的路径数量
    System.out.println(absolutePath.getNameCount());

    System.out.println(absolutePath.getName(2));
    // 以多个String来构建path对象
    Path path2 = Paths.get("g:", "public", "codes");
    System.out.println(path2);
  }
}
