package thread.控制线程通信.线程组和未处理异常;

/**
 * @author zhouT
 * @date 2019/构建器/11 20:54
 */
class MyExHandle implements Thread.UncaughtExceptionHandler {

  // 处理线程的未处理异常
  @Override
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println(t + "出现了异常：" + e);
  }
}

public class ExHandle {
  public static void main(String[] args) {
    // 设置主线程的异常处理器
    Thread.currentThread().setUncaughtExceptionHandler(new MyExHandle());
    int a = 5 / 0;
    System.out.println("程序正常结束~");
  }
}
