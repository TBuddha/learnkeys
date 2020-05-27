package io.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author zhouT
 * @date 2018/12/27 17:08
 */
public class FileVisitorTest {
  public static void main(String[] args) throws Exception {
    Files.walkFileTree(
        Paths.get("d:", "ideaProject", "YJwork", "SpraceXBootDemo"),
        new SimpleFileVisitor<Path>() {
          // 访问文件时触发该方法
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            System.out.println("正在访问->" + file);
            if (file.endsWith("FileVisitorTest.java内置")) {
              System.out.println("已找到目标文件");
              return FileVisitResult.TERMINATE;
            }
            return FileVisitResult.CONTINUE;
          }
          // 访问目录时触发该方法
          @Override
          public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
              throws IOException {
            System.out.println("正在访问：" + dir + "路径");
            return FileVisitResult.CONTINUE;
          }
        });

    // WatchService监控文件变化 711
    // 访问文件属性 712
  }
}
