package 数据结构.二叉树;

public class Client {

  /**
   * 先序遍历
   *
   * @param rootTreeNode 根节点
   */
  public static void preTraverseBTree(TreeNode rootTreeNode) {

    if (rootTreeNode != null) {

      // 访问左节点
      preTraverseBTree(rootTreeNode.getLefTreeNode());

      // 访问根节点
      System.out.println(rootTreeNode.getValue());

      // 访问右节点
      preTraverseBTree(rootTreeNode.getRightNode());
    }
  }

  /**
   * 中序遍历
   *
   * @param rootTreeNode 根节点
   */
  public static void inTraverseBTree(TreeNode rootTreeNode) {

    if (rootTreeNode != null) {

      // 访问根节点
      System.out.println(rootTreeNode.getValue());

      // 访问左节点
      inTraverseBTree(rootTreeNode.getLefTreeNode());

      // 访问右节点
      inTraverseBTree(rootTreeNode.getRightNode());
    }
  }

  /**
   * 后序遍历
   *
   * @param rootTreeNode 根节点
   */
  public static void postTraverseBTree(TreeNode rootTreeNode) {

    if (rootTreeNode != null) {

      // 访问左节点
      postTraverseBTree(rootTreeNode.getLefTreeNode());

      // 访问右节点
      postTraverseBTree(rootTreeNode.getRightNode());

      // 访问根节点
      System.out.println(rootTreeNode.getValue());
    }
  }

  public static void main(String[] args) {
    // 根节点-->10
    TreeNode treeNode1 = new TreeNode(10);

    // 左孩子-->9
    TreeNode treeNode2 = new TreeNode(9);

    // 右孩子-->20
    TreeNode treeNode3 = new TreeNode(20);

    // 20的左孩子-->15
    TreeNode treeNode4 = new TreeNode(15);

    // 20的右孩子-->35
    TreeNode treeNode5 = new TreeNode(35);

    // 根节点的左右孩子
    treeNode1.setLefTreeNode(treeNode2);
    treeNode1.setRightNode(treeNode3);

    // 20节点的左右孩子
    treeNode3.setLefTreeNode(treeNode4);
    treeNode3.setRightNode(treeNode5);

    // 先序遍历
    preTraverseBTree(treeNode1);
  }
}
