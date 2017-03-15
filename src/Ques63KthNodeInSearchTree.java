import common.ListNode;
import common.TestInstance;
import common.TreeNode;

import java.util.Stack;

/**
 * 求二叉搜索树的第k个节点
 * Created by oubin on 17-3-15.
 */
public class Ques63KthNodeInSearchTree {

    /**
     * 递归实现
     * @param root
     * @param k
     * @return
     */
    public static TreeNode getKthNode(TreeNode root, int k){
        if (root == null || k <= 0) return null;

        return getKNode(root, k);
    }

    private static TreeNode getKNode(TreeNode root, int k) {
        TreeNode target = null;

        if (root.left != null){
            target = getKNode(root.left, k);
        }
        if (target == null){
            if (k == 1)
                target = root;
            k--;
        }
        if ((target == null) && (root.right != null)){
            target = getKNode(root.right, k);
        }
        return target;
    }

    /**
     * 迭代实现
     * @param root
     * @param k
     * @return
     */
    public static TreeNode getKthNode2(TreeNode root, int k){
        if (root == null || k <= 0) return null;

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                k--;
                if (k == 0) return curr;
                curr = curr.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getKthNode2(TestInstance.getBinaryTree(),7).val);
    }

}
