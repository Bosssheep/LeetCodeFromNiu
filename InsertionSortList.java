
import entity.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 思路:新建一个链表,遍历原链表，将每个节点加入新链表正确的位置
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head){
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while(cur != null){
            //保存当前节点下一个节点
            ListNode next = cur.next;
            //从头便利新的链表，直到找到第一个大于等于当前cur的节点或者最后一个节点
            pre = dumy;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            //当前cur节点加入新链表中
            cur.next = pre.next;
            pre.next = cur;

            //处理下一个节点
            cur = next;
        }
        return dumy.next;
    }
}
