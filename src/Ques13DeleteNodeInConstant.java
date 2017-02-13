import common.ListNode;

/**
 * 在O(1)时间内删除链表中的一个节点
 * 考虑：不同位置上的不一样
 * 用例：正常链表的中间元素，链表的最后一个，单一元素的链表
 * Created by oubin on 17-2-13.
 */
public class Ques13DeleteNodeInConstant {

    public ListNode delete(ListNode head,ListNode node){
        if(head == null || node == null) return head;
        ListNode helper = new ListNode(1);
        helper.next = head;
        if(node.next == null){
            node = null;
        }else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return helper.next;
    }

}
