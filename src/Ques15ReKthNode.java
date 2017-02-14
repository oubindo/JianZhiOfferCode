import common.ListNode;

/**
 * 获得链表中倒数第k个节点
 * 考虑：双指针
 * 测试用例：head为空，k < 0, 链表长度小于k
 * Created by oubin on 17-2-14.
 */
public class Ques15ReKthNode {

    // 注意，我们这里是以0开始计数的。
    public ListNode getReKthNode(ListNode head, int k){
        if(head == null || k < 0){
            throw new IllegalArgumentException("Argument error");
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && k > 0){
            fast = fast.next;
            k--;
        }
        if(k > 0)
            throw new IllegalArgumentException("k太大了，哥");
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
