package Tree;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given binary tree{3,9,20,#,#,15,7},
      3
    / \
   9  20
  /  \
 15   7
 return its zigzag level order traversal as:
 [[3],[20,9],[15,7]]

 */
public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int flag = 1;
        while(!queue.isEmpty()){
            //记录当前的节点个数
            int num = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            if(flag%2==1){
                for(int i=0;i<num;i++){
                    TreeNode node = queue.poll();
                    tempList.add(node.val);
                    if(node.left!=null)
                        queue.offer(node.left);
                    if(node.right!=null)
                        queue.offer(node.right);
                }
                flag++;
            }
            else{
                for(int i=0;i<num;i++){
                    TreeNode node = queue.pollLast();
                    tempList.add(node.val);
                    if(node.right!=null)
                        queue.offerFirst(node.right);
                    if(node.left!=null)
                        queue.offerFirst(node.left);
                }
                flag++;
            }
            result.add(tempList);
        }
        return result;
    }
}

