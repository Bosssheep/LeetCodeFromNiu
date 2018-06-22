
import entity.RandomListNode;

/**
 *
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 Return a deep copy of the list.
 思想;
 先拷贝新节点，插入到原节点的后边；然后再 拷贝随机指针；最后将新节点从原链表中分离出，注意要保证原链表正常。
 */
public class copy_list_with_random_pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        RandomListNode p = head;

        //先拷贝新节点，插入到原节点的后边
        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }

        // 拷贝随机指针
        p = head;
        RandomListNode newNode ;
        while(p != null){
            newNode = p.next;
            if(p.random != null)
                newNode.random = p.random.next;
            p = p.next.next;
        }

        //最后将新节点从原链表中分离出，注意要保证原链表正常
        p = head;
        RandomListNode res = p.next;
        while(p.next !=null){
            RandomListNode tmp = p.next;
            p.next = p.next.next;
            p = tmp;

        }
        return head;
    }
}
