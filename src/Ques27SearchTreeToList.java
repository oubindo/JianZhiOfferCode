import common.TestInstance;
import common.TreeNode;

/**
 * 输入一颗二叉搜索树，将二叉搜索树转换成排序的双向链表。不能创建任何新的节点，只能调整节点指针的指向
 * 考虑：使用中序遍历和递归，问题是怎么样去将左子树的最后一个和右子树的第一个区分开来。
 * 测试用例：空head，单一节点，左右单链，正常数
 * Created by oubin on 17-2-16.
 */
public class Ques27SearchTreeToList {
    public TreeNode leftLast = null;

    public TreeNode convert(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) return root;

        // 递归左子树，获取到链表头
        TreeNode left = convert(root.left);
        TreeNode temp = left;
        // 将节点移到最后，然后可以和root连接起来
        while (temp.right != null) temp = temp.right;
        if (root != left){
            root.left = left;
            temp.right = root;
        }
        TreeNode right = convert(root.right);
        if (right != null){
            root.right = right;
            right.left = root;
        }
        return left == null ? root : left;
    }

    public TreeNode convert2(TreeNode root){
        if (root == null) return root;
        // 只有在最左边的节点才给leftLast赋了值
        if (root.left == null && root.right == null) {
            leftLast = root;
            return root;
        }
        TreeNode left = convert2(root.left);
        if (left != null){
            leftLast.right = root;
            root.left = leftLast;
        }
        leftLast = root;
        TreeNode right = convert2(root.right);
        if (right != null){
            right.left = root;
            root.right = right;
        }
        return left != null?left:root;
    }

    public static void main(String[] args) {
        Ques27SearchTreeToList list = new Ques27SearchTreeToList();
        list.convert2(TestInstance.getSearchTree());
    }
}
