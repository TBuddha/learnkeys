package chapter1_1;

import repo.StdDraw;
import repo.StdRandom;

import java.awt.*;

/**
 * @author zhout
 * @date 2020/9/25 16:02
 */
public class Ex31 {

  // 随机连接。编写一段程序，从命令行接受一个整数 N 和 double 值 p(0 到 1 之间)作为参数，
  // 在一个圆上画出大小为 0.05 且间距相等的 N 个点，然后将每对点按照概率 p 用灰线连接。
  // https://www.jianshu.com/p/551687a757d8
  static class Point {
    double x;
    double y;

    public Point(double x, double y) {
      super();
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    double p = Double.parseDouble(args[1]);
    if (p < 0 || p > 1) {
      System.out.println("p is not valid!");
      return;
    }
    Point[] points = new Point[N];
    double angle = 360.0 / N;
    StdDraw.circle(0.5, 0.5, 0.5);
    // 设置画笔的大小
    StdDraw.setPenRadius(0.05);
    for (int i = 0; i < N; i++) {
      points[i] =
          new Point(
              0.5 + 0.5 * Math.cos(angle * i * Math.PI / 180),
              0.5 + 0.5 * Math.sin(angle * i * Math.PI / 180));
      // 画个点
      StdDraw.point(points[i].x, points[i].y);
    }
    StdDraw.setPenRadius(0.01);
    // 设置画笔颜色
    StdDraw.setPenColor(Color.GRAY);
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (StdRandom.bernoulli(p)) {
          StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
        }
      }
    }
  }
}
