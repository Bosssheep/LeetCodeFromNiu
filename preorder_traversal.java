import  entity.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal  of its nodes' values.
 先序遍历定义：根，左，右
 使用栈后+广度遍历：根，右，左
 */
public class preorder_traversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            result.add(p.val);
            if(p.right != null)
                stack.push(p.right);
            if(p.left != null)
                stack.push(p.left);
        }
        return  result;
    }

}
