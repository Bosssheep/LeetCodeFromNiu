package Array;

import entity.TreeNode;

/**
 * 把一个有序数组转换成一颗二分查找树。
 * 从本质来看，如果把一个数组看成一棵树（也就是以中点为根，左右为左右子树，依次下去）
 * 数组就等价于一个二分查找树。
 * 所以如果要构造这棵树，那就是把中间元素转化为根，然后递归构造左右子树。
 * 所以我们还是用二叉树递归的方法来实现，以根作为返回值，每层递归函数取中间元素，
 * 作为当前根和赋上结点值，然后左右结点接上左右区间的递归函数返回值。
 * 时间复杂度还是一次树遍历O(n)，
 * 总的空间复杂度是栈空间O(logn)加上结果的空间O(n)，额外空间是O(logn)，总体是O(n)。
 */
public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0 || num==null)
            return null;
        return sortedArrayToBSTHeper(num,0,num.length-1);
    }
    public TreeNode sortedArrayToBSTHeper(int[] num,int left,int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(num[left]);
        }
        int mid = left+(right-left+1)/2;  //(left+right+1)/2
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBSTHeper(num,left,mid-1);
        root.right=sortedArrayToBSTHeper(num,mid+1,right);
        return root;
    }
}
