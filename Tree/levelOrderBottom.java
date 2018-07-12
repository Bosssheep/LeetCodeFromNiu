package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历，从叶子节点向root将每行数据写进一个数组
 * 如：[[15,7]，[9,20],[3],]
 * 每层遍历都将这层数据数组插入0位
 */
public class levelOrderBottom {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null)
            return result;

        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> res = new ArrayList<>();
            int nums = queue.size();//每层节点数
            for(int i =0;i<nums;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                res.add(node.val);
            }
            result.add(0,res);
        }
        return result;
    }
}
