package Tree;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 层序遍历，按层打印
 */

/**
 * Given binary tree{3,9,20,#,#,15,7},
      3
    / \
   9  20
  /  \
 15   7
 return its level order traversal as:
 [[3],[9,20],[15,7]]

 *
 */
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int num = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0;i<num;i++){
                TreeNode note = queue.poll();
                temp.add(note.val);
                if(note.left!=null){
                    queue.offer(note.left);
                }
                if(note.right!=null){
                    queue.offer(note.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
