package Tree;

import entity.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 根据中序遍历（左-中-右）和后序遍历建立树（左-右-中）
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder.length!=postorder.length)
                return null;

            return buildHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }


    public TreeNode buildHelper(int[] inorder,int from1,int to1,int[] postorder,int from2,int to2){
        if(from1>to1)
            return null;

        TreeNode root = new TreeNode(postorder[to2]);
        if(from1==to1)
            return root;
        //在inorder中找到根节点，分成左右两部分
        int index = from1;
        for(int i=from1;i<=to1;i++){
            if(root.val==inorder[index]) {
                index = i;
                break;
            }
        }

        int leftLength = index - from1;


        //递归左子树和右子树
        root.left = buildHelper(inorder, from1, from1 + leftLength - 1, postorder, from2, from2 + leftLength - 1);
        root.right = buildHelper(inorder, from1 + leftLength + 1, to1, postorder, from2 + leftLength,
                to2 - 1);

        return root;
    }
}
