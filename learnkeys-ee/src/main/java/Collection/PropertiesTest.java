package Collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author zhoutao
 * @date 2019/6/20 17:20
 */
public class PropertiesTest {
  public static void main(String[] args) throws Exception {
    Properties props = new Properties();
    // 向Properties中增加属性
    props.setProperty("username", "yeeku");
    props.setProperty("password", "123456");
    // 将Properties中的属性保存到a.ini文件中
    props.store(new FileOutputStream("a.ini"), "comment line");
    // 新建一个Properties对象
    Properties props2 = new Properties();
    // 向Properties中增加属性
    props2.setProperty("gender", "male");
    // 将a.ini文件中的属性名-属性值追加到props2中
    props2.load(new FileInputStream("a.ini"));
    System.out.println(props2);
  }
}
