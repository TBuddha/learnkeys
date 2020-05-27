package 面向对象.equals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouT
 * @date 2019/5/15 19:25
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
class Monkey {
  private String name;
  private String idStr;

  // 重写equals方法，提供自定义的相等标准
  public boolean equals(Object obj) {
    // 待比较的两个对象是同一个对象，直接返回true
    if (this == obj) {
      return true;
    }
    // 只有当obj是Person对象
    if (obj != null && obj.getClass() == Monkey.class) {
      Monkey personObj = (Monkey) obj;
      // 并且当前对象的idStr与obj对象的idStr相等才可判断两个对象相等
      if (this.getIdStr().equals(personObj.getIdStr())) {
        return true;
      }
    }
    return false;
  }
}

public class OverrideEqualsRight {
  public static void main(String[] args) {
    Monkey p1 = new Monkey("孙悟空", "12343433433");
    Monkey p2 = new Monkey("孙行者", "12343433433");
    Monkey p3 = new Monkey("孙悟饭", "99933433");
    // p1和p2的idStr相等，所以输出true
    System.out.println("p1和p2是否相等？" + p1.equals(p2));
    // p2和p3的idStr不相等，所以输出false
    System.out.println("p2和p3是否相等？" + p2.equals(p3));
  }
}
