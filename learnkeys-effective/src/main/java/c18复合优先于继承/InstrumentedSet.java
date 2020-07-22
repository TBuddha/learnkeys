package c18复合优先于继承;

import java.util.Collection;
import java.util.Set;

/**
 * @author zhoutao
 * @date 2019/9/9 16:41
 */
class InstrumentedSet<E> extends ForwardingSet<E> {

  private int addCount = 0;

  public InstrumentedSet(Set<E> set) {
    super(set);
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount(){
    return addCount;
  }
}
