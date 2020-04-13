package com.zhout.重新组织函数.引入解释性变量;

/**
 * @author zhout
 * @date 2020/4/13 16:25
 */
public class Demo {

  private String platform = "MAC";

  private String browser = "IE";

  private boolean wasInitialized() {
    return true;
  }

  private Integer resize = 1;

  public void foo1() {
    if ((platform.toUpperCase().indexOf("MAC") > -1)
        && (browser.toUpperCase().indexOf("IE") > -1)
        && wasInitialized()
        && resize > 0) {
      // do something
    }
  }

  public void foo2() {
    final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
    final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
    final boolean wasResized = resize > 0;
    if (isMacOs && isIEBrowser && wasInitialized() && wasResized) {
      // do something
    }
  }
}
