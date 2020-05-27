package io.nio2;

import com.google.common.collect.Lists;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author zhouT
 * @date 2018/12/27 15:11
 */
public class FilesTest {
  public static void main(String[] args) throws Exception {
    // 复制文件
    Path path =
        Paths.get(
            "D:\\ideaProject\\YJwork\\SpraceXBootDemo\\web-start\\src\\main\\java内置\\com\\yunjiacloud\\nj\\SpraceXBootDemo\\core\\io\\nio2\\FilesTest.java内置");
    Files.copy(path, new FileOutputStream("a.txt"));
    // 判断FilesTest.java是否为隐藏文件
    System.out.println(Files.isHidden(path));
    // 一次性读取FilesTest.java文件的所有行
    List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));
    System.out.println(lines);
    // 判断指定文件的大小
    System.out.println(Files.size(path));

    List<String> poem = Lists.newArrayList("水晶潭底银鱼跃", "清徐风中碧竿横");
    // 直接将多个字符串内容写入指定文件中
    Files.write(Paths.get("poem.txt"), poem, Charset.forName("UTF-8"));
    // 读取当前目录下所有文件和子文件
    Files.list(Paths.get(".")).forEach(item -> System.out.println(item));

    // 读取文件内容
    Files.lines(path, Charset.forName("UTF-8")).forEach(line -> System.out.println(line));

    FileStore cStore = Files.getFileStore(Paths.get("C:"));
    // 判断C盘总空间，可用空间
    System.out.println(cStore.getTotalSpace());
    System.out.println(cStore.getUnallocatedSpace());
  }
}
