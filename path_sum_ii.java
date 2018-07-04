import entity.TreeNode;
import java.util.ArrayList;

/**
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree andsum = 22,
             5
           / \
         4   8
       /   /  \
     11  13   4
   /  \     / \
 7    2   5   1
 return:
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
思路：
 列表的循环添加，注意添加完一个数之后要移除这个数
 */
public class path_sum_ii {
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return results;
        }
        path(root,sum,list);
        return results;
    }
    public  void path(TreeNode root,int sum,ArrayList<Integer> list){
        if(root==null)
            return;
        if(root.left==null && root.right==null && sum-root.val==0){
            list.add(root.val);
            results.add(new ArrayList<>(list));//不能直接添加list，这样是引用
            list.remove(list.size()-1);//回退最后一位
            return;
        }
        list.add(root.val);
        path(root.left,sum-root.val,list);//继续遍历左子树
        path(root.right,sum-root.val,list);//继续遍历右子树
        list.remove(list.size()-1);//回退最后一位
    }
}
