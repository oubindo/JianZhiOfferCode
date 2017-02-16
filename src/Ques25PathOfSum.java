import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。路径指从根节点到叶节点。
 * 考虑：可以使用一个总的列表，然后里面是一些小列表，在每次递归时进入一个节点后就复制前面的列表，这样就可以不止一个列表了。
 * 测试用例：空头节点，单一节点，正常树，左右单链树。(自己写测试用例太麻烦了...)
 * 特别注意：这个是从头节点到尾节点，所以一定不能把null的子结点考虑进去
 * Created by oubin on 17-2-15.
 */
public class Ques25PathOfSum {

    public List<List<Integer>> printPathOfSum(TreeNode root, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        if(root.left != null) findPath(result, rootList, root.left, root.val, target);
        if(root.right != null) findPath(result, rootList, root.right, root.val, target);
        if(root.left == null && root.right == null){
            if (root.val == target) result.add(rootList);
        }
        return result;
    }

    private void findPath(List<List<Integer>> result, List<Integer> rootList, TreeNode root, int sum, int target) {
        List<Integer> newList = new ArrayList<>(rootList);
        sum += root.val;
        newList.add(root.val);
        if(root.left != null) findPath(result, newList, root.left, sum, target);
        if(root.right != null) findPath(result, newList, root.right, sum, target);
        if (root.left == null && root.right == null){
            if (sum == target) result.add(newList);
        }
    }

}
