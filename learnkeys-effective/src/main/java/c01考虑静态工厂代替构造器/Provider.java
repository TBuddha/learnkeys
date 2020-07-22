package c01考虑静态工厂代替构造器;

/**
 * @author zhoutao@yunjiacloud.com
 * @date 2019/8/28 16:58
 */
interface Provider {
   Service newService();
}
