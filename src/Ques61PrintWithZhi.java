import common.TreeNode;

import java.util.Stack;

/**
 * 按之字形打印树。
 * 利用两个栈和一个标志位来确定应该怎么放
 * Created by oubin on 17-3-15.
 */
public class Ques61PrintWithZhi {

    public static void printWithZhi(TreeNode root){
        if (root == null) return;
        boolean isOdd = true;
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(root);
        while (!(oddStack.isEmpty() && evenStack.isEmpty())){
            if (isOdd){
                while(!oddStack.isEmpty()){
                    TreeNode node = oddStack.pop();
                    System.out.print(node.val + "  ");
                    if (node.left != null) evenStack.push(node.left);
                    if (node.right != null) evenStack.push(node.right);
                }
                isOdd = false;
            }else{
                while(!evenStack.isEmpty()){
                    TreeNode node = evenStack.pop();
                    System.out.print(node.val + "  ");
                    if (node.right != null) oddStack.push(node.right);
                    if (node.left != null) oddStack.push(node.left);
                }
                isOdd = true;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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
        printWithZhi(node);
    }


}
