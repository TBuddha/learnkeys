package c15使类和成员的可访问性最小化;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhoutao
 * @date 2019/9/6 17:49
 */
class UnmodifiableArray {

  private static final Thing[] PRIVATE_VALUES = {};

  //建议1；提供共有的不可变列表
  public static List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

  //建议2：返回私有数组的一个备份
  //final表示这个方法不能被复写, 既然static方法本来就不具备复写的条件, 再加final就显得多余了, 所以IDE给了warning
  public static final Thing[] valuess(){
    return PRIVATE_VALUES.clone();
  }

  private class Thing {}
}
