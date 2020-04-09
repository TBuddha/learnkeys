package com.zhout.测试体系;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author zhout
 * @date 2020/4/1 14:39
 */
public class FileReaderTester extends TestCase {

  Reader _input;

  public FileReaderTester(String name) {
    super(name);
  }

  @Override
  protected void setUp() {
    try {
      _input = new FileReader("data.txt");
    } catch (FileNotFoundException e) {
      throw new RuntimeException("unable to open test file");
    }
  }

  @Override
  protected void tearDown() {
    try {
      _input.close();
    } catch (IOException e) {
      throw new RuntimeException("error on closing test file");
    }
  }

  //  public void testRead() throws IOException {
  //    char ch = '&';
  //    for (int i = 0; i < 4; i++) ch = (char) _input.read();
  //    // assert ('d' == ch);
  //    // assertEquals('d', ch);
  //    assertEquals('m', ch);
  //  }

  public void testRead() throws IOException {
    char ch = '&';
    _input.close();
    for (int i = 0; i < 4; i++) ch = (char) _input.read(); // will throw exception
    assertEquals('m', ch);
  }

  public void testReadAtEnd() throws IOException {
    int ch = -1234;
    for (int i = 0; i < 141; i++) ch = _input.read();
    assertEquals(-1, ch);
  }

  public void testReadBoundaries() throws IOException {
    assertEquals("read first char", 'B', _input.read());
    int ch;
    for (int i = 1; i < 140; i++) ch = _input.read();
    assertEquals("read last char", '6', _input.read());
    assertEquals("read at end", -1, _input.read());
  }

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTest(new FileReaderTester("testRead"));
    suite.addTest(new FileReaderTester("testReadAtEnd"));
    return suite;
  }

  public static void main(String[] args) {
    // junit.textui.TestRunner.run(suite());
    junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
  }
}
