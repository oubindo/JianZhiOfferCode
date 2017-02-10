import common.ListNode;

import java.util.Stack;

/**
 * 题目：输入一个链表的头节点，从尾到头反过来打印除每个节点的值。
 * 分析：这个题要问考官是否可以更改链表的顺序，如果可以的话，可以采用反转链表的方法，不可以的话，可以使用Stack或者是递归，如果使用递归就要考虑
 *      如果链表过长，导致函数调用栈过深，导致函数调用栈溢出的情况。这里使用栈和递归求解
 * Created by oubin on 17-2-9.
 */
public class Ques5ReverseLinkedList {
    public static void printLinkedList(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head=head.next;
        }
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            System.out.println(node.val);
        }
    }

    public static void printLinkedList2(ListNode head){
        if(head == null) return;
        if(head.next != null){
            printLinkedList2(head.next);
        }
        System.out.println(head.val);
    }
}
