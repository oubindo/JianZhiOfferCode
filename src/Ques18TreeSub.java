import common.ListNode;
import common.TreeNode;

/**
 * 输入两个二叉树A和B，判断B是不是A的子结构，
 * 考虑：先遍历找到这个结点，然后判断是否是相同的结构
 * 测试用例：头节点为空，含有子结构，不含有子结构
 * Created by oubin on 17-2-14.
 */
public class Ques18TreeSub {

    public boolean isTreeSub(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) return false;

        boolean result = false;
        if (tree1.val == tree2.val) {
            result = doesTree1HaveTree2(tree1, tree2);
            if (!result) {
                result = isTreeSub(tree1.left, tree2);
            }
            if (!result) {
                result = isTreeSub(tree1.right, tree2);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode tree1, TreeNode tree2) {
        // 特别要注意这点，这点可以截取子树一的部分结构
        if (tree2 == null) return true;
        if (tree1 == null) return false;
        if (tree1.val != tree2.val) return false;

        return doesTree1HaveTree2(tree1.left, tree2.left) && doesTree1HaveTree2(tree2.right, tree2.right);
    }
}
