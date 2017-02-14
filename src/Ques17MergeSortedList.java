import common.ListNode;
import common.TestInstance;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点依然是递增排序的。
 * 考虑：使用归并排序的思想来连接这个链表
 *
 * Created by oubin on 17-2-14.
 */
public class Ques17MergeSortedList {

    public ListNode mergeSortedList(ListNode head1, ListNode head2){
        if(head1 == null && head2 == null) return null;
        else if(head1 == null) return head2;
        else if(head2 == null) return head1;

        ListNode helper = new ListNode(0);
        ListNode head = helper;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                helper.next = new ListNode(head1.val);
                head1 = head1.next;
            }else{
                helper.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            helper = helper.next;
        }
        while(head1 != null){
            helper.next = new ListNode(head1.val);
            head1 = head1.next;
            helper = helper.next;
        }
        while(head2 != null){
            helper.next = new ListNode(head2.val);
            head2 = head2.next;
            helper = helper.next;
        }
        return head.next;
    }

    public static void main(String[] args){
        Ques17MergeSortedList sortedList = new Ques17MergeSortedList();
        System.out.println(sortedList.mergeSortedList(TestInstance.getList(),TestInstance.getList2()));

    }

}
