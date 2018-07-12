package linkedlist;
/**
 * 把有序链表转为二叉搜索树
 * 与sortedArrayToBST很像
 * 链表的查找中间点可以通过快慢指针来操作；
 * 到中点后，要以中点的值建立一个数的根节点，
 * 然后需要把原链表断开，分为前后两个链表，都不能包含原中节点，然后再分别对这两个链表递归调用原函数，分别连上左右子节点即可。
 */

import entity.ListNode;
import entity.TreeNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return BSTHelper(head,null);
    }

    public TreeNode BSTHelper(ListNode head,ListNode tail){
        if(head == tail)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时slow为中间的那个节点
        TreeNode root = new TreeNode(slow.val);
        root.left = BSTHelper(head,slow);
        root.right = BSTHelper(slow.next,tail);

        return root;
    }
}
