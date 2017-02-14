import common.ListNode;

/**
 * 反转一个链表并输出头结点。
 * 分析：使用三个指针
 * 测试用例：head为空，多个节点，一个节点
 * Created by oubin on 17-2-14.
 */
public class Ques16ReverseList {

    public ListNode reverseList(ListNode head){
        if (head == null) return null;

        ListNode pre = head;
        ListNode curr = head.next;
        head.next = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args){
        Ques16ReverseList list = new Ques16ReverseList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(list.reverseList(l1));
    }

}
