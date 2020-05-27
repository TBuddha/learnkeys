package internet.URLConnection;

/**
 * @author zhouT
 * @date 2019/构建器/22 15:11
 */
public class MultiThreadDown {
  public static void main(String[] args) throws Exception {
    // 初始化DownUtil对象
    final DownUtil downUtil =
        new DownUtil(
            "http://img05.tooopen.com/images/20150711/tooopen_sy_133485961826.jpg",
            "common.jpg",
            4);
    // 开始下载
    downUtil.download();
    new Thread(
            () -> {
              while (downUtil.getCompleteRate() < 1) {
                System.out.println("已完成：" + downUtil.getCompleteRate());
                // 每隔0.01秒查询一次任务的完成进度
                try {
                  Thread.sleep(100);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            })
        .start();
  }
}
