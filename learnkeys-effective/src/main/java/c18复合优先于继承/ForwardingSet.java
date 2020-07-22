package c18复合优先于继承;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhoutao
 * @date 2019/9/9 16:36
 */
class ForwardingSet<E> implements Set<E> {

  private final Set<E> set;

  public ForwardingSet(Set<E> set) {
    this.set = set;
  }

  public int size() {
    return set.size();
  }

  public boolean isEmpty() {
    return set.isEmpty();
  }

  public boolean contains(Object o) {
    return set.contains(o);
  }

  public Iterator<E> iterator() {
    return set.iterator();
  }

  public Object[] toArray() {
    return set.toArray();
  }

  public <T> T[] toArray(T[] a) {
    return set.toArray(a);
  }

  public boolean add(E e) {
    return set.add(e);
  }

  public boolean remove(Object o) {
    return set.remove(o);
  }

  public boolean containsAll(Collection<?> c) {
    return set.containsAll(c);
  }

  public boolean addAll(Collection<? extends E> c) {
    return set.addAll(c);
  }

  public boolean retainAll(Collection<?> c) {
    return set.retainAll(c);
  }

  public boolean removeAll(Collection<?> c) {
    return set.removeAll(c);
  }

  public void clear() {
    set.clear();
  }

  @Override
  public boolean equals(Object obj){
    return set.equals(obj);
  }

  @Override
  public int hashCode() {
    return set.hashCode();
  }

  @Override
  public String toString() {
    return set.toString();
  }
}
