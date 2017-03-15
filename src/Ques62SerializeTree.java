import common.TreeNode;

/**
 * 序列化和反序列化一棵树。
 * 考虑：采用前序遍历
 * Created by oubin on 17-3-15.
 */
public class Ques62SerializeTree {

    public static void serializeTree(TreeNode root){
        if (root == null){
            System.out.print("$, ");
            return;
        }
        System.out.print(root.val+", ");
        serializeTree(root.left);
        serializeTree(root.right);
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
        serializeTree(node);
    }

}
