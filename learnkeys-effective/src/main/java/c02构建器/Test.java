package c02构建器;

import c02构建器.NutritionFacts.Builder;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/9/2 15:28
 */
class Test {

  public static void main(String[] args) {
    NutritionFacts cocaCola = new Builder(240, 8)
        .calories(5).sodium(7).carbohydrate(8).fat(3).build();
    System.out.println("--" + cocaCola);
  }
}
