import common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * 输入一个二叉树，输出他的镜像
 * 考虑：镜像其实就是一个节点的左右节点换了一下。可以使用递归或循环
 * 测试用例：空节点，单一根节点，完整树
 * Created by oubin on 17-2-15.
 */
public class Ques19MirrorOfTree {

    public TreeNode getMirror(TreeNode root){
        if (root == null) return null;
        // 实现调换
        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        // 向下遍历
        if (root.left != null) {
            getMirror(root.left);
        }
        if (root.right != null){
            getMirror(root.right);
        }
        return root;
    }

    public TreeNode getMirror2(TreeNode root){
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode leftTemp = node.left;
            node.left = node.right;
            node.right = leftTemp;
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return root;
    }

}
