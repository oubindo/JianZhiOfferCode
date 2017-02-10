import common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 通过前序和中序遍历重建树。
 * Created by oubin on 17-2-9.
 */
public class Ques6RebuildTree {

    public static TreeNode rebuildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        return rebuildTreeHelper(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private static TreeNode rebuildTreeHelper(int[] firstOrder, int[] midOrder, int firstLeft,
                                              int firstRight, int midLeft, int midRight) {
        TreeNode root = new TreeNode(firstLeft);
        // 防止只有一个根节点的情况,其实不用也行。
        if(firstLeft == firstRight && midLeft == midRight){
            return root;
        }
        int rootIndex = 0;
        for (int i = midLeft; i <= midRight; i++) {
            if (firstOrder[firstLeft] == midOrder[i]) {
                rootIndex = i;
            }
        }
        int span = rootIndex - midLeft;
        if(span > 0)  root.left = rebuildTreeHelper(firstOrder, midOrder, firstLeft + 1, firstLeft+span, midLeft, rootIndex - 1);
        if(span < firstRight - firstLeft)root.right = rebuildTreeHelper(firstOrder, midOrder, firstLeft + span + 1, firstRight, rootIndex + 1, midRight);
        return root;
    }
}
