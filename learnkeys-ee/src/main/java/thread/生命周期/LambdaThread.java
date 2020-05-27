package thread.生命周期;

/**
 * @author zhouT
 * @date 2019/构建器/11 15:20
 */
class LambdaThread extends Thread {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      // 获取当前线程
      System.out.println(Thread.currentThread().getName() + " " + i);
      if (i == 5) {
        Thread thread1 =
            new Thread(
                () -> {
                  for (int j = 0; j < 10; j++) {
                    // 当线程类继承thread类时，直接使用this即可获取当前线程
                    // Thread对象的getName()返回当前线程的的名字
                    // 因此可以直接调用getName()方法返回当前线程的名字
                    System.out.println(Thread.currentThread().getName() + " " + j);
                    try {
                      sleep(1000); // 休眠1秒，避免太快导致看不到同时执行
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }
                  }
                });
        thread1.start();
      }

      try {
        sleep(1000); // 休眠1秒，避免太快导致看不到同时执行
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
