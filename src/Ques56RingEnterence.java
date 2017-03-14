import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中环的入口节点：一个链表中含有环，如何找出环的入口结点。
 * 考虑：使用一快一满两个指针，快的一次走两步，慢的一次走一步。如果相遇一定在环中，接着一边计数一遍前移，直到再次回到该点。
 * Created by oubin on 17-3-9.
 */
public class Ques56RingEnterence {

    public static ListNode meetNode(ListNode head){
        if (head == null) return null;

        ListNode slow = head.next;
        if (slow == null) return null;

        ListNode fast = slow.next;
        while (fast != null && slow != null){
            if (fast == slow) return fast;

            slow = slow.next;

            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    public static ListNode getRingEnterence(ListNode head){
        // step1:判断是否有环，并得到环中的某个点
        ListNode meetNode = meetNode(head);
        if (meetNode == null) return null;

        // 找到环的长度
        ListNode lenNode = meetNode.next;
        int count = 1;
        while(lenNode != meetNode) {
            lenNode = lenNode.next;
            count++;
        }

        // 从头找到环
        ListNode node = head;
        for (int i = 0; i < count; i++){
            node = node.next;
        }
        ListNode node2 = head;
        while(node != node2){
            node = node.next;
            node2 = node2.next;
        }
        return node;
    }

    public static void main(String[] args) {


    }

    /*
    * 写码心得：下面几个点易错
    * 1.当使用node.next.next时，除非已经可以确定node.next不为空，否则一定要先判断
    * 2.当找到了环的长度后，要用两个指针来一起移动。
    *
    */

}
