import common.TreeNode;

/**
 * 使用递归法，不断的判断对应的子树是否相等
 * Created by oubin on 17-3-14.
 */
public class Ques59SymmetricalTree {

    public static boolean isSymmetrical(TreeNode root){
        return  isSymmetricalTree(root.left, root.right);
    }

    private static boolean isSymmetricalTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return isSymmetricalTree(left.left,right.right) && isSymmetricalTree(left.right, right.left);
    }

}
