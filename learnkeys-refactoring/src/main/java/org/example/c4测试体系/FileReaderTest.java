package org.example.c4测试体系;

import com.google.common.io.Resources;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @author zhout
 * @date 2020/4/9 11:15
 */
class FileReaderTest {

  Reader _input;
  Reader _empty;

  //  @Before
  //  public void setUp() {
  //    try {
  //      // _input = new FileReader("data.txt");
  //      _input = new FileReader(Resources.getResource("data.txt").getFile());
  //    } catch (FileNotFoundException e) {
  //      throw new RuntimeException("unable to open test file");
  //    }
  //  }

  @Before
  public void setUp() {
    try {
      _input = new FileReader(Resources.getResource("data.txt").getFile());
      _empty = newEmptyFile();
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
  }

  @After
  public void tearDown() {
    try {
      _input.close();
    } catch (IOException e) {
      throw new RuntimeException("error on closing test file");
    }
  }

  @Test
  public void testRead() throws IOException {
    char ch = '&';
    for (int i = 0; i < 4; i++) ch = (char) _input.read();
    assert ('d' == ch);
  }

  @Test
  public void testRead1() throws IOException {
    char ch = '&';
    for (int i = 0; i < 4; i++) ch = (char) _input.read();
    assert ('2' == ch); // deliberate error
  }

  @Test
  public void testRead2() throws IOException {
    char ch = '&';
    for (int i = 0; i < 4; i++) ch = (char) _input.read();
    Assert.assertEquals('m', ch);
  }

  @Test
  public void testRead3() throws IOException {
    char ch = '&';
    _input.close();
    for (int i = 0; i < 4; i++) ch = (char) _input.read(); // will throw exception
    Assert.assertEquals('m', ch);
  }

  @Test
  public void testReadAtEnd() throws IOException {
    int ch = -1234;
    for (int i = 0; i < 141; i++) ch = _input.read();
    Assert.assertEquals(-1, ch);
  }

  @Test
  public void testReadBoundaries() throws IOException {
    Assert.assertEquals("read first char", 'B', _input.read());
    int ch;
    for (int i = 1; i < 140; i++) ch = _input.read();
    Assert.assertEquals("read last char", '6', _input.read());
    Assert.assertEquals("read at end", -1, _input.read());
  }

  @Test
  public void testEmptyRead() throws IOException {
    File empty = new File("empty.txt");
    FileOutputStream out = new FileOutputStream(empty);
    out.close();
    FileReader in = new FileReader(empty);
    Assert.assertEquals(-1, in.read());
  }

  @Test
  public void testEmptyRead2() throws IOException {
    Assert.assertEquals(-1, _empty.read());
  }

  private FileReader newEmptyFile() throws IOException {
    File empty = new File("empty.txt");
    FileOutputStream out = new FileOutputStream(empty);
    out.close();
    return new FileReader(empty);
  }

  @Test
  public void testReadBoundaries2() throws IOException {
    Assert.assertEquals("read first char", 'B', _input.read());
    int ch;
    for (int i = 1; i < 140; i++) ch = _input.read();
    Assert.assertEquals("read last char", '6', _input.read());
    Assert.assertEquals("read at end", -1, _input.read());
    Assert.assertEquals("read past end", -1, _input.read());
  }

  @Test
  public void testReadAfterClose() throws IOException {
    _input.close();
    try {
      // Assert.fail("no exception for read past end");
      _input.read();
      Assert.fail("no exception for read past end");
    } catch (IOException e) {
    }
  }
}
