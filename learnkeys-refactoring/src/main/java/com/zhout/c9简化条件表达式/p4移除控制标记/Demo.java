package com.zhout.c9简化条件表达式.p4移除控制标记;

/**
 * Remove Control Flag（移除控制标记）
 *
 * @author zhout
 * @date 2020/4/26 18:22
 */
class Demo {

  // 在一系列条件表达式中，你常常会看到「用以判断何时停止条件检查」的控制标记（control flag）：
  //  set done to false
  //  while not done
  //  if (condition)
  //     do something
  //     set done to true
  //  next step of loop
  // 这样的控制标记带来的麻烦超过了它所带来的便利。人们之所以会使用这样的控制标记，
  // 因为结构化编程原则告诉他们：每个子程序（routines）只能有一个入口（entry）
  // 和一个出口（exit）。我赞同「单一入口」原则（而且现代编程语言也强迫我们这样做），
  // 但是「单一出口」原则会让你在代码中加入讨厌的控制标记，大大降低条件表达式的可读性。
  // 这就是编程语言提供break 语句和continue 语句的原因：你可以用它们跳出复杂的条件语句。
  // 去掉控制标记所产生的效果往往让你大吃一惊：条件语句真正的用途会清晰得多
}
