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

    public static ListNode getEmptyList(){
        return null;
    }

    public static ListNode getOneNodeList(){
        ListNode l1 = new ListNode(1);
        return l1;
    }
}
