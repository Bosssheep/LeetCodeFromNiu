import entity.TreeLinkNode;

public class populating_next_right_pointers_in_each_node {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        if (root.left!=null && root.right!=null)
            root.left.next = root.right;
        if (root.next != null &&root.right!=null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
