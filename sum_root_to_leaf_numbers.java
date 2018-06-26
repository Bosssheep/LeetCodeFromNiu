import entity.TreeNode;

/**
 * The root-to-leaf path1->2represents the number12.
   The root-to-leaf path1->3represents the number13.
   Return the sum = 12 + 13 =25.
 */
public class sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return sum(root,0);

    }
    public int sum(TreeNode root,int sum){
        if(root==null)
            return 0;
        sum = sum*10+root.val;
        if(root.left == null && root.right == null) return sum;
        return sum(root.left,sum)+sum(root.right,sum);
    }
}
