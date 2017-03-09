import common.Util;

/**
 * 数组中重复的数字：一个长度为n的数组中所有数字都在0到n-1的范围内，数组中有些数字是重复的。返回任意一个重复的数字
 * 考虑：1.排序，2.哈希表  3.要注意到  一个长度为n的数组中所有数字都在0到n-1的范围内 这个条件，条件一定是有用的。我们将数组重排。
 * 这个算法是O(n)的时间复杂度，O(1)的空间复杂度
 * Created by oubin on 17-3-8.
 */
public class Ques51DuplicateNums {

    public static int duplicate(int nums[]){
        if (nums == null || nums.length == 0) return -1;

        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if (nums[nums[i]] == nums[i]) return nums[i];
                Util.swap(nums, nums[i], i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2,1,0,2,5,3}));
    }
}
