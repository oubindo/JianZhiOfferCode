package common;

/**
 * Created by oubin on 17-2-14.
 */
public class Util {

    public static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
