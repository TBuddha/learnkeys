package org.example.c10简化函数调用.p9引入参数对象.after;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author zhout
 * @date 2020/5/6 15:47
 */
class Account {

  // 1、接下来我把DateRange 对象加到getFlowBetween() 函数的参数列中：
  //  double getFlowBetween(Date start, Date end, DateRange range) {
  //    double result = 0;
  //    Enumeration e = _entries.elements();
  //    while (e.hasMoreElements()) {
  //      Entry each = (Entry) e.nextElement();
  //      if (each.getDate().equals(start)
  //          || each.getDate().equals(end)
  //          || (each.getDate().after(start) && each.getDate().before(end))) {
  //
  //        result += each.getValue();
  //      }
  //    }
  //    return result;
  //  }

  // 2、下一个步骤是去除旧参数之一，以新建对象取而代之。首先我删除start 参数，并修改getFlowBetween() 函数及其调用者，让它们转而使用新对象：
  //  double getFlowBetween(Date end, DateRange range) {
  //    double result = 0;
  //    Enumeration e = _entries.elements();
  //    while (e.hasMoreElements()) {
  //      Entry each = (Entry) e.nextElement();
  //      if (each.getDate().equals(range.getStart())
  //          || each.getDate().equals(end)
  //          || (each.getDate().after(range.getStart()) && each.getDate().before(end))) {
  //
  //        result += each.getValue();
  //      }
  //    }
  //    return result;
  //  }

  // 3、移除end参数
  //  double getFlowBetween(DateRange range) {
  //    double result = 0;
  //    Enumeration e = _entries.elements();
  //    while (e.hasMoreElements()) {
  //      Entry each = (Entry) e.nextElement();
  //      if (each.getDate().equals(range.getStart())
  //          || each.getDate().equals(range.getEnd())
  //          || (each.getDate().after(range.getStart()) && each.getDate().before(range.getEnd())))
  // {
  //        result += each.getValue();
  //      }
  //    }
  //    return result;
  //  }

  /**
   * 4、现在，我已经引入了「参数对象」。我还可以将适当的行为从其他函数移到这个新建对象中，进一步从本项重构获得更大利益。
   * 这里，我选定条件式中的代码，实施Extract Method 和Move Method，最后得到如下代码：
   */
  double getFlowBetween(DateRange range) {
    double result = 0;
    Enumeration e = _entries.elements();
    while (e.hasMoreElements()) {
      Entry each = (Entry) e.nextElement();
      /** Extract Method 和Move Method */
      if (range.includes(each.getDate())) {
        result += each.getValue();
      }
    }
    return result;
  }

  private Vector _entries = new Vector();
}
