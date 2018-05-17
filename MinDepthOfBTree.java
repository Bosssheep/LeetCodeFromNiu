/**
 * Question:
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest 
 * path from the root node down to the nearest leaf node.
 * Method:
 *  使用层序遍历的方法，直到找到第一个叶子节点
 * @Date 2018-5-17
 * @Author ChenHanYi
*/


import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBTree {
    public int run(TreeNode root) {
		if(root == null){
		    return 0;
        }
        if(root.left == null && root.right == null){
		    return 1;
        }

        int depth = 0;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while(!temp.isEmpty()){
            depth++;
            int len = temp.size();
            for(int i=0;i<len;i++){
                TreeNode node = temp.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null)
                    temp.offer(node.left);
                if(node.right != null)
                    temp.offer(node.right);
            }
        }
        return depth;
    }
}