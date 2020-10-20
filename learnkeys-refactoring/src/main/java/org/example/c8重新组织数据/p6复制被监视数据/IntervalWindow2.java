package org.example.c8重新组织数据.p6复制被监视数据;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author zhout
 * @date 2020/4/21 10:18
 */
class IntervalWindow2 extends Frame implements Observer {

  java.awt.TextField _startField;
  java.awt.TextField _endField;
  java.awt.TextField _lengthField;

  // IntervalWindow class需要与此崭新的domain class建立一个关联
  private Interval _subject;

  public IntervalWindow2() {
    // 我需要合理地初始化_subject值域，并把IntervalWindow class变成Interval
    // class的一个Observer。这很简单,只需把下列代码放进IntervalWindow2构造函数中就可以了
    _subject = new Interval();
    _subject.addObserver(this);
    update(_subject, null);
  }

  @Override
  public void update(Observable observed, Object arg) {
    // 确保GUI 对Interval 对象发来的通告做出响应
    _endField.setText(_subject.getEnd());
  }

  // 1、第一件要做的事就是实施 Self Encapsulate Field
  // 文本框的更新是通过getText()和setText()两函数实现的，因此我所建立的访问函数（accessors）需要调用这两个函数：
  //  String getEnd() {
  //    return _endField.getText();
  //  }
  //
  //  void setEnd(String arg) {
  //    _endField.setText(arg);
  //  }

  // ==>
  // 2、修改IntervalWindow class 的访问函数，令它们改用Interval 对象
  // 同时也修改update() 函数，确保GUI 对Interval 对象发来的通告做出响应
  String getEnd() {
    return _subject.getEnd();
  }

  void setEnd(String arg) {
    _subject.setEnd(arg);
  }

  /** 找出_endField 的所有引用点，将它们替换为适当的访问函数： */
  void calculateLength() {
    try {
      int start = Integer.parseInt(_startField.getText());
      int end = Integer.parseInt(getEnd());
      int length = end - start;
      _lengthField.setText(String.valueOf(length));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }

  void calculateEnd() {
    try {
      int start = Integer.parseInt(_startField.getText());
      int length = Integer.parseInt(_lengthField.getText());
      int end = start + length;
      setEnd(String.valueOf(end));
    } catch (NumberFormatException e) {
      throw new RuntimeException("Unexpected Number Format Error");
    }
  }

  //  void EndField_FocusLost(java.awt.event.FocusEvent event) {
  //    if (isNotInteger(getEnd())) setEnd("0");
  //    calculateLength();
  //  }
  // ==>
  void EndField_FocusLost(java.awt.event.FocusEvent event) {
    setEnd(_endField.getText()); // 译注：注意对以下对此行的讨论
    if (isNotInteger(getEnd())) setEnd("0");
    calculateLength();
  }
  // 这是Self Encapsulate Field 的标准过程。然而当你处理GUI class 时，情况还更复杂些：用户可以直接（通过GUI ）修改文本框内容，不必调用setEnd() 。
  // 因此我需要在GUI class 的事件处理函数中加上对setEnd() 的调用。这个动作把文本框设定为其当前值。当然，这没带来什么影响，但是通过这样的方式，我
  // 们可以确保用户的输入的确是通过设值函数（setter）进行的
  // --------------------------------------------------------------------//
  /** *************************** */

  boolean isNotInteger(String arg) {
    try {
      Integer.parseInt(arg);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
