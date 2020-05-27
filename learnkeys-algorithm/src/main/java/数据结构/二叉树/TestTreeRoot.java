package 数据结构.二叉树;

public class TestTreeRoot {
  /**
   * 动态创建二叉查找树
   *
   * @param root 根节点
   * @param value 节点的值
   */
  public static void createTree(TreeRoot root, int value) {

    // 如果树根为空(第一次访问)，将第一个值作为根节点
    if (root.getTreeRoot() == null) {
      TreeNode treeNode = new TreeNode(value);
      root.setTreeRoot(treeNode);

    } else {
      // 当前树根
      TreeNode tempRoot = root.getTreeRoot();

      while (tempRoot != null) {
        // 当前值大于根值，往右边走
        if (value > tempRoot.getValue()) {

          // 右边没有树根，那就直接插入
          if (tempRoot.getRightNode() == null) {
            tempRoot.setRightNode(new TreeNode(value));
            return;
          } else {
            // 如果右边有树根，到右边的树根去
            tempRoot = tempRoot.getRightNode();
          }
        } else {
          // 左没有树根，那就直接插入
          if (tempRoot.getLefTreeNode() == null) {
            tempRoot.setLefTreeNode(new TreeNode(value));
            return;
          } else {
            // 如果左有树根，到左边的树根去
            tempRoot = tempRoot.getLefTreeNode();
          }
        }
      }
    }
  }

  /**
   * 查询树的深度我们可以这样想：左边的子树和右边的字数比，谁大就返回谁，那么再接上根节点+1就可以了
   *
   * @param treeNode
   * @return
   */
  public static int getHeight(TreeNode treeNode) {

    if (treeNode == null) {
      return 0;
    } else {
      // 左边的子树深度
      int left = getHeight(treeNode.getLefTreeNode());

      // 右边的子树深度
      int right = getHeight(treeNode.getRightNode());

      int max = left;

      if (right > max) {
        max = right;
      }
      return max + 1;
    }
  }

  /**
   * 找出树的最大值
   *
   * @param rootTreeNode
   */
  public static int getMax(TreeNode rootTreeNode) {

    if (rootTreeNode == null) {
      return -1;
    } else {
      // 找出左边的最大值
      int left = getMax(rootTreeNode.getLefTreeNode());

      // 找出右边的最大值
      int right = getMax(rootTreeNode.getRightNode());

      // 与当前根节点比较
      int currentRootValue = rootTreeNode.getValue();

      // 假设左边的最大
      int max = left;

      if (right > max) {
        max = right;
      }
      if (currentRootValue > max) {
        max = currentRootValue;
      }
      return max;
    }
  }

  public static void main(String[] args) {
    int[] arrays = {2, 3, 1, 4, 5};

    // 动态创建树

    TreeRoot root = new TreeRoot();
    for (int value : arrays) {
      createTree(root, value);
    }

    /*//先序遍历树
    Client.preTraverseBTree(root.getTreeRoot());
    System.out.println("---------------");

    //中序遍历树
    Client.inTraverseBTree(root.getTreeRoot());
    System.out.println("---------------");

    //后序遍历树
    Client.postTraverseBTree(root.getTreeRoot());
    System.out.println("---------------");*/

    // System.out.println(getHeight(root.getTreeRoot()));

    System.out.println(getMax(root.getTreeRoot()));
  }
}
