import common.TreeNode;

/**
 * 第一题是求二叉树的深度   第二题是判断是否为平衡二叉树的改进做法
 * Created by oubin on 17-2-17.
 */
public class Ques39DepthOfTree {

    public static int treeDepth(TreeNode root){
        if (root == null) return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static boolean isBalanced(TreeNode root){
        int[] depth = new int[1];
        return isBalanced(root, depth);
    }

    // 这种解法是只需要遍历节点一次的解法
    private static boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (isBalanced(root.left, depth) && isBalanced(root.right, depth)){
            int diff = Math.abs(left[0] - right[0]);
            if (diff <= 1){
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }

    // 这种解法是需要遍历节点多次的解法
    public static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    // 可以看到上述两种方法的区别就是，如果从上往下，绝对是要遍历多次节点的，如果从下往上，以下面的结果作为条件，可以只遍历节点一次。

}
