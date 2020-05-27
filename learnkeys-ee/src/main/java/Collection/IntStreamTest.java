package Collection;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author zhoutao
 * @date 2019/6/12 17:44
 */
public class IntStreamTest {
  public static void main(String[] args) {
    IntStream intStream = IntStream.builder().add(20).add(13).add(-2).add(18).build();
    // 映射成一个新的Stream
    IntStream newIntStream = intStream.map(ele -> ele * 2 + 1);
    newIntStream.forEach(System.out::println);

    List<Integer> list = Lists.newArrayList(1, 2, 3);
    list.forEach(System.out::println);
  }
}
