package Tree;

import entity.TreeNode;

/**
 * 根据先序遍历（中-左-右）、中序遍历（左-中-右）获得树
 */
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length)
            return null;

        return buildHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    public TreeNode buildHelper(int[] inorder,int inLeft,int inRight,int[] preorder,int preLeft,int preRight){
        if(inLeft>inRight)
            return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        if(inLeft==inRight)
            return root;
        //在inorder中找到根节点，分成左右两部分
        int index = 0;
        for(int i=inLeft;i<=inRight;i++){
            if(root.val==inorder[i]) {
                index = i;
                break;
            }
        }

        int leftLength = index - inLeft;

        //递归左子树和右子树
        root.left = buildHelper(inorder, inLeft, inLeft + leftLength - 1, preorder, preLeft+1, preLeft+leftLength);
        root.right = buildHelper(inorder, leftLength + 1, inRight, preorder, preLeft+leftLength+1,
                preRight);

        return root;
    }
}
