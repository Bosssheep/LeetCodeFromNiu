import entity.ListNode;

/**
 * 如果链表循环，则返回环起始的节点，否则返回null
 * 思路：
 *      先用快慢两个指针找到相遇位置 z
 *      再用两个指针分别指向起始位置head和z，往前走，两个指针相遇位置就是环的起始节点
 */
public class linkedlist_findrecyclebegin {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        //先用快慢两个指针找到相遇位置 z
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null || fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }

        if(fast.next==null || fast.next.next == null)
            return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
