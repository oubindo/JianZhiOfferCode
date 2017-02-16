package common;

/**
 * Created by oubin on 17-2-14.
 */
public class TestInstance {
    public static ListNode getList(){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    public static ListNode getList2(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        return l1;
    }

    public static RandomListNode getRandomList(){
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        n1.next = n2;
        n1.random = n3;
        n2.next = n3;
        n2.random = n4;
        n3.next = n4;
        n4.random = n1;
        return n1;
    }

    public static ListNode getEmptyList(){
        return null;
    }

    public static ListNode getOneNodeList(){
        ListNode l1 = new ListNode(1);
        return l1;
    }
}
