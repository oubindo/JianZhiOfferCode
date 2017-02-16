/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索数的后序遍历的结果
 * 考虑：使用递归来处理
 * 测试用例：对和错的数组，只有一个数字的数组，空数组,单链树
 *
 * 学习心得：
 * 1.如果只需要一个结果，只要直接return就行
 * 2.如果需要多个结果进行判断再给出最终结果，使用一个变量记录
 * 3.如果需要多个结果，并且每个结果相互影响的，使用一个变量，并且控制好各个结果的顺序和判断条件
 * Created by oubin on 17-2-15.
 */
public class Ques24PostOrderTree {

    public boolean isTree(int[] postOrder){
        if (postOrder == null || postOrder.length == 0) return false;

        int end = postOrder.length - 1;
        return isTreeHelp(postOrder, 0, end);
    }

    private boolean isTreeHelp(int[] postOrder, int start, int end) {
        if (start >= end) return true;

        int root = postOrder[end];
        int index = start;
        while (postOrder[index] < root){
            index++;
        }
        int temp = index;
        for (; temp < end; temp++){
            if (postOrder[temp] < root) return false;
        }
        return isTreeHelp(postOrder, start, index - 1) && isTreeHelp(postOrder, index, end - 1);
    }

    public static void main(String[] args) {
        Ques24PostOrderTree tree = new Ques24PostOrderTree();
        System.out.println(tree.isTree(new int[]{1}));
        System.out.println(tree.isTree(new int[]{5,7,6,9,11,10,8}));
        System.out.println(tree.isTree(new int[]{7,4,6,5}));
        System.out.println(tree.isTree(new int[]{4,5,6,7}));
    }

}
