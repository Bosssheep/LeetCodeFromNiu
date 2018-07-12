package Tree;

import entity.TreeNode;

/**
给一个二叉树，判断是否是平衡二叉树
 */
public class balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return helper(root)!=-1;
    }

    //返回高度，如果高度差为-1，则返回-1
    public int helper(TreeNode root){
        int left,right;
        if(root==null)
            return 0;
        left = helper(root.left);
        right = helper(root.right);
        if(left==-1 || right==-1)
            return -1;
        if(Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
