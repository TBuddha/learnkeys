package org.example.csv;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zhout
 * @date 2020/10/20 10:08
 */
@Slf4j
public class ExportCSVUtil<T> {

  private Class<T> cls; // 数据类型
  private List<T> list; // 填充数据
  private List<Method> methods; // 存储get方法

  /**
   * 该方式导出csv文件会显示标题
   *
   * @param list 填充数据
   * @param cls 数据类型
   * @throws Exception
   */
  public ExportCSVUtil(List<T> list, Class<T> cls) throws Exception {
    this.list = list;
    this.cls = cls;
    parse();
  }

  /**
   * 调用此方法，将数据写出到指定的文件流中
   *
   * @param out 输出流
   * @throws Exception
   */
  public void doExport(OutputStream out) throws Exception {
    byte[] bytes = new byte[] {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}; // utf8编码
    out.write(bytes); // 写入BOM
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, "utf8");
    BufferedWriter writer = new BufferedWriter(outputStreamWriter);
    writeBody(writer, list); // 写内容
    outputStreamWriter.flush();
    outputStreamWriter.close();
  }

  /**
   * 写数据
   *
   * @throws InvocationTargetException
   * @throws IllegalArgumentException
   * @throws IllegalAccessException
   * @throws IOException
   */
  public void writeBody(BufferedWriter writer, List<T> list)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
          IOException {
    // 数据遍历
    for (T obj : list) {
      int i = 0;
      int length = methods.size();
      for (Method method : methods) {
        Object result = method.invoke(obj, new Object[] {});
        String str = null;
        if (result == null) // 处理空值
        str = "";
        else str = result.toString().replaceAll("\"", "\"\""); // 处理文本中的"

        if (i++ <= length - 1) writer.write("\"" + str + "\","); // 文本用双引号包裹
        else writer.write("\"" + str + "\""); // 最后的元素需要使用换行符而不是“，” 需要特别注意
      }
      writer.newLine(); // 换行
    }
  }

  /** 解析实体类，获取get或者 is方法 */
  private void parse() throws NoSuchMethodException {
    // java文档上其实说过，该方法获取到的列表并不能保证其顺序。严格的来说应该对变量上添加排序的注解，
    // 然后对获取到的元素进行重新排序。实际使用的时候，获取到的数组就是声明属性的顺序，可能在某些情况下会有问题。
    Field[] fields = cls.getDeclaredFields();
    // 根据属性获取方法，当然也可以直接获取方法
    for (Field field : fields) {
      String fieldName = field.getName();
      Method method = null;
      try {
        // 普通get方法   getXnnn
        cls.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
      } catch (Exception e) {

      }
      if (method == null) {
        try {
          // bool属性对应的方法  isXnn
          cls.getDeclaredMethod("is" + StringUtils.capitalize(fieldName));
        } catch (Exception e) {
        }
      }
      // 方法不存在时抛出异常
      if (method == null)
        throw new NoSuchMethodException(cls + "的属性" + fieldName + "对象没有对应的getter 方法");

      methods.add(method); // 获取getter方法
    }
  }
}
