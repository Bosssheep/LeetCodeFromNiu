import entity.ListNode;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
   reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 思路：
   快慢指针找到中间节点，将后面的链表反转（前插法），合并链表
 */
public class reorder_list {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return ;

        //找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //翻转后半段
        ListNode after = slow.next;
        slow.next = null;
        ListNode pre = null;
        while(after != null){
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }

        //合并前后两个链表 头节点分别是head和slow
        ListNode first = head;
        after = pre;
        while(first!=null && after!=null){
            ListNode fTemp = first.next;
            ListNode aTemp = after.next;
            first.next = after;
            after.next = fTemp;
            first = fTemp;
            after = aTemp;
        }

    }
}
