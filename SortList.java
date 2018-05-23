import entity.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 方法：使用归并排序
 1）找到链表中点 （快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，慢指针恰好在链表中点）；
 2）写出merge函数，即如何合并链表。 （见merge-two-sorted-lists 一题解析）
 3）写出mergesort函数，实现上述步骤。
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = fineMiddle(head);
        ListNode midNext = middle.next;
        middle.next = null;
        return mergeTwoLists(sortList(head),sortList(midNext));
    }

    public ListNode fineMiddle(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        //找到链表中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null  && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1,ListNode list2) {
        ListNode p1 = list1, p2 = list2, tmp = null, head = null, p = null;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                tmp = p1;
                p1 = p1.next;
            }else{
                tmp = p2;
                p2 = p2.next;
            }
            if(head == null){
                head = tmp;
                p = tmp;
            }else{
                p.next = tmp;
                p = p.next;
            }
        }
        if(p1 != null)
            p.next = p1;
        if(p2 != null)
            p.next = p2;

        return head;
    }
}

