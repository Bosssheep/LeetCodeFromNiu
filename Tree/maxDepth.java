package Tree;

import entity.TreeNode;

/**
求树的最大深度
 */
public class maxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
