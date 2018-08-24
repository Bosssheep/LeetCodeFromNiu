package Tree;

import entity.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
   后序遍历递归定义：先左子树，后右子树，再根节点。
   使用栈后+广度遍历：根，右，左 -> 翻转顺序 ：左，右，根
 */
public class postorder_traversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       Stack<Integer> stackTemp  = new Stack<>();
       if(root == null)
           return list;
       stack.push(root);
       while(!stack.isEmpty()){
           TreeNode node = stack.pop();
           stackTemp.push(node.val);
           if(node.left != null)
               stack.push(node.left);
           if(node.right != null)
               stack.push(node.right);
       }
       while(!stackTemp.isEmpty()){
           list.add(stackTemp.pop());
       }
       return list;
    }
}

