package c18复合优先于继承;

import com.google.common.collect.ForwardingList;

import java.util.Collection;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.log;

/**
 * @author zhoutao
 * @date 2019/12/25 10:30
 *
 * Guava提供的转发类(组合实现)
 */
class AddLoggingList<E> extends ForwardingList<E> {

  private final List<E> delegate; // backing list

  public AddLoggingList(List<E> delegate) {
    this.delegate = delegate;
  }

  @Override
  protected List<E> delegate() {
    return delegate;
  }

  @Override
  public void add(int index, E elem) {
    log(index, elem);
    super.add(index, elem);
  }

  @Override
  public boolean add(E elem) {
    return standardAdd(elem); // implements in terms of add(int, E)
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return standardAddAll(c); // implements in terms of add
  }

}
