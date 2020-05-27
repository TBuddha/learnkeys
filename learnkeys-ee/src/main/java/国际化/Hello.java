package 国际化;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author zhoutao
 * @date 2019/6/11 16:01
 */
public class Hello {
  public static void main(String[] args) {
    Locale locale = Locale.getDefault(Locale.Category.FORMAT);
    ResourceBundle bundle = ResourceBundle.getBundle("mess", locale);
    String keyValue =
        new String(
            bundle.getString("hello").getBytes(StandardCharsets.ISO_8859_1),
            StandardCharsets.UTF_8);
    System.out.println(keyValue);
  }
}
