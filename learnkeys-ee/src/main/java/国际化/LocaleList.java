package 国际化;

import java.util.Locale;

/**
 * @author zhoutao
 * @date 2019/6/11 14:28
 */
public class LocaleList {
  public static void main(String[] args) {
    Locale[] locales = Locale.getAvailableLocales();
    for (Locale locale : locales) {
      System.out.println(
          locale.getDisplayCountry()
              + "--"
              + locale.getDisplayLanguage()
              + "--"
              + locale.getLanguage());
    }
  }
}
