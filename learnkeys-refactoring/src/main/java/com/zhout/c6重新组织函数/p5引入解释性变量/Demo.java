package com.zhout.c6重新组织函数.p5引入解释性变量;

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

  public void foo() {
    if ((platform.toUpperCase().indexOf("MAC") > -1)
        && (browser.toUpperCase().indexOf("IE") > -1)
        && wasInitialized()
        && resize > 0) {
      // do something
    }
  }

  // 将该表达式（或其中一部分）的结果放进一个临时变量，以此变量名称来解释表达式用途
  public void foo2() {
    final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
    final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
    final boolean wasResized = resize > 0;
    if (isMacOs && isIEBrowser && wasInitialized() && wasResized) {
      // do something
    }
  }
}
