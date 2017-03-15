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

    public static TreeNode getSearchTree(){
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(9);
        n3.left = n6;
        n3.right = n7;
        return n1;
    }

    public static TreeNode getBinaryTree(){
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        return node;
    }

}
