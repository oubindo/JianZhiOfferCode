import java.util.Arrays;

/**
 * 给出任意多的数字，判断是否为顺子。
 * 考虑：1.使用List，一个一个加入 2.排序         -------- 没有考虑到的点是大小王的个数，和相邻数字的间隔综述
 * Created by oubin on 17-3-1.
 */
public class Ques44Puke {

    public static boolean isConstant(int[] nums){
        if (nums == null || nums.length == 0) return false;

        Arrays.sort(nums);
        int zeroNums = 0;
        int gapNums = 0;

        // 这里有一个更好的实现方式就是不要去遍历那些非0的区域。
        /*for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) zeroNums++;
        }*/
        for (int i = 0; i < nums.length && nums[i] == 0; i++){
            zeroNums++;
        }


        int small = zeroNums;
        int big = small + 1;
        while (big < nums.length){
            if (nums[small] == nums[big]) return false;

            gapNums += nums[big] - nums[small] - 1;
            small++;
            big++;
        }
        return gapNums <= zeroNums;
    }

    public static void main(String[] args) {
        System.out.println(isConstant(new int[]{5,1,0,2,6}));
    }

}
