import entity.TreeNode;

import java.util.Map;

/**
 *  Given a binary tree, find the maximum path sum.The path may start and end at any node in the tree.
 For example:
     1
   / \
 2   3
 Return 6
 这里的路径不仅可以从根到某一个结点，
 而且路径可以从左子树某一个结点，然后到达右子树的结点，就像题目中所说的可以起始和终结于任何结点。
 在这里树没有被看成有向图，而是被当成无向图来寻找路径。
 一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），加上右子树的返回值（如果大于0的话），再加上自己的值。
 * 而返回值则是自己的值加上左子树返回值，返回值是为了提供给它的父结点计算自身的最长路径用，
 */
public class binarytree_maximum_path_sum {
    public int maxValue = 0;
    public  int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        getMaxPath(root);
        return maxValue;
    }

    public int getMaxPath(TreeNode root){
        if(root == null)
            return 0;
        int leftMax = Math.max(0,getMaxPath(root.left));
        int rightMax = Math.max(0,getMaxPath(root.right));
        maxValue = Math.max(maxValue,root.val+leftMax+rightMax);
        return Math.max(0, root.val + Math.max(leftMax, rightMax));
    }
}
