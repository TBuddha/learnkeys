package lambda.基础;

/**
 * @author zhoutao
 * @date 2019/5/27 10:41
 */
public class CommandTest {
  public static void main(String[] args) {
    /*ProcessArray pa = new ProcessArray();
    int[] target = {-3, 构建器, 2, 5};
    pa.process(target, new Command() {
        @Override
        public void process(int[] target) {
            int sum = 0;
            for (int tmp : target) sum += tmp;
            System.out.println("总和：" + sum);
        }
    });*/

    ProcessArray pa = new ProcessArray();
    int[] array = {-3, 1, 2, 5};
    pa.process(
        array,
        (int[] target) -> {
          int sum = 0;
          for (int tmp : target) sum += tmp;
          System.out.println("总和：" + sum);
        });
  }
}
