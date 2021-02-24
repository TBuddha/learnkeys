package org.example.io;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author zhout
 * @date 2020/4/7 15:27
 */
class FileDemo {
  public static void main(String[] args) {
    File file = new File(System.getProperty("user.dir"));
  }

  // 写文件
  private void writeFile(String content, File file) throws IOException {
    if (!file.exists()) {
      file.createNewFile();
    }
    Files.write(content.getBytes(Charsets.UTF_8), file);
  }

  // 读文件
  private List<String> readFile(File file) throws IOException {
    if (!file.exists()) {
      return ImmutableList.of(); // 避免返回null
    }
    return Files.readLines(file, Charsets.UTF_8);
  }

  // 文件复制
  private void copyFile(File from, File to) throws IOException {
    if (!from.exists()) {
      return;
    }
    if (!to.exists()) {
      to.createNewFile();
    }
    Files.copy(from, to);
  }
}
