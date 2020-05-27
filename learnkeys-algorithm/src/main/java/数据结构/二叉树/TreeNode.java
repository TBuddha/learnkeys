package 数据结构.二叉树;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreeNode {
  // 左节点(儿子)
  private TreeNode lefTreeNode;
  // 右节点(儿子)
  private TreeNode rightNode;
  // 数据
  private int value;

  public TreeNode(int value) {
    this.value = value;
  }
}
