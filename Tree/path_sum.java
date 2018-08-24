package Tree;

import entity.TreeNode;

/**
 * 给定一个数，求是否存在根到叶子的路径
 */
public class path_sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return path(root,sum);
    }
    public boolean path(TreeNode root,int sum){
        if(root==null)
            return false;
        if(root.left==null && root.right==null && root.val == sum){
            return true;
        }
        return path(root.left,sum-root.val) || path(root.right,sum-root.val);
    }
}
