import java.util.Arrays;

/**
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 考虑：使用归并排序
 * Created by oubin on 17-2-17.
 */
public class Ques36ReversePair {

    public static int reversePair(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] copy = new int[nums.length];
        return mergeSort(nums, copy, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }

        int mid = (start + end) / 2;
        int leftCount = mergeSort(nums, copy, start, mid);
        int rightCount = mergeSort(nums, copy, mid + 1, end);

        int i = mid, j = end;
        int indexCopy = end;
        int mergeCount = 0;
        while (i >= start && j >= mid + 1){
            if (nums[i] > nums[j]){
                copy[indexCopy--] = nums[i--];
                mergeCount += j - mid;  // 前面的和后面的都排好序了，这样就可以求得前面的数会比多少个后面的数大
            } else {
                copy[indexCopy--] = nums[j--];
            }
        }
        for (;i >= start; --i){
            copy[indexCopy--] = nums[i];
        }
        for (;j > mid; --j){
            copy[indexCopy--] = nums[j];
        }
        return leftCount + rightCount + mergeCount;
    }

    public static void main(String[] args) {
        System.out.println(reversePair(new int[]{7,4,5,3,1}));
    }

}
