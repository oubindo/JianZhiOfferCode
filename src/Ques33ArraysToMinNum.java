import java.util.Comparator;

/**
 * 把数组排成最小的数，比如给出[23,2,43],最小的就是22343
 * 考虑：实现一个java的comparator,然后使用快速排序，可以实现O(nlgn)的算法
 * 测试用例：空数组，只有一个元素，全是一样的元素，正常元素
 * Created by oubin on 17-2-17.
 */
public class Ques33ArraysToMinNum {

    public String arrayToNum(String[] nums) {
        if (nums == null || nums.length == 0) return "";

        CustomComparator comparator = new CustomComparator();
        quickSort(nums, 0, nums.length - 1, comparator);
        StringBuilder builder = new StringBuilder();
        for (String s : nums) {
            builder.append(s);
        }
        return builder.toString();
    }

    private void quickSort(String[] nums, int start, int end, CustomComparator comparator) {
        if (start < end) {
            String pivot = nums[start];
            int left = start;
            int right = end;
            while (left < right) {
                while (left < right && comparator.compare(nums[right], pivot) >= 0) {
                    right--;
                }
                nums[start] = nums[right];
                while (left < right && comparator.compare(nums[left], pivot) < 0) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = pivot;
            quickSort(nums, start, left - 1, comparator);
            quickSort(nums, left + 1, end, comparator);
        }
    }


    public class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1 == null || s2 == null) return 0;
            String sa1 = s1 + s2;
            String sa2 = s2 + s1;
            return sa1.compareTo(sa2);
        }
    }

    public static void main(String[] args) {
        Ques33ArraysToMinNum num = new Ques33ArraysToMinNum();
        System.out.println(num.arrayToNum(new String[]{"23","1","65","4"}));
    }

}
