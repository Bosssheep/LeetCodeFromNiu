import entity.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * Given the following binary tree,
      1
    /  \
   2    3
  / \    \
 4   5    7
 After calling your function, the tree should look like:
          1 -> NULL
       /  \
     2 -> 3 -> NULL
   / \    \
 4-> 5 -> 7 -> NULL
思路：
 如果当前层所有结点的next 指针已经设置好了，那么据此，下一层所有结点的next指针 也可以依次被设置。
 tmpLevelFirst为新建立的每层第一个节点（为了方便后面遍历当前行节点）
 */

public class populating_next_right_pointers_in_each_node_ii {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            //tmpLevelFirst为新建立的每层第一个节点（为了方便后面遍历当前行节点）
            TreeLinkNode tmpLevelFirst = new TreeLinkNode(0);
            TreeLinkNode cur = tmpLevelFirst;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = tmpLevelFirst.next;
        }
    }
}
