import common.TreeNode;

import java.util.*;

/**
 * 把一棵二叉树打印成多行，同一层按从左到右的顺序打印。
 * 考虑：层序遍历
 * Created by oubin on 17-3-14.
 */
public class Ques60PrintTreeToMultiRow {

    public static void printTree(TreeNode root){
        if (root == null) return;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int curr = 1;
        int next = 0;
        while(!list.isEmpty()){
            for (; curr > 0; curr--){
                TreeNode node = list.remove(0);
                System.out.print(node.val + "  ");
                if (node.left != null) {
                    list.add(node.left);
                    next++;
                }
                if (node.right != null){
                    list.add(node.right);
                    next++;
                }
            }
            System.out.println();
            curr = next;
            next = 0;
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
        printTree(node);
    }

}
