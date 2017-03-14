import common.ListNode;

/**
 * 删除排好序的链表中重复的节点
 * 考虑：双指针
 * 测试用例：空节点，只有一个节点，只有两个相同节点，只有两个不同节点，有多个节点且有相同点，无相同点。
 * 做题心得：本题我做的时候在当前点和下一点是否相同没有做判断，导致了prev是否移动没有找到一个判断条件，这点失策。
 * Created by oubin on 17-3-14.
 */
public class Ques57DeleteDuplicateNode {

    public static ListNode deleteDuplicate(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode helper = new ListNode(1);
        helper.next = head;
        ListNode prev = helper;
        ListNode node = head;
        while(node != null && node.next != null){
            if (node.val == node.next.val){
                while(node.next != null && node.val == node.next.val){
                    node = node.next;
                }
                prev.next = node.next;
            } else {
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        return helper.next;
    }


    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode result = deleteDuplicate(n1);
        print(result);
    }
}
