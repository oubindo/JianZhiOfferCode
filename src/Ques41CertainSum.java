import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第一题：输入一个递增排序的数组和一个数字，在数组中查找两个数使得他们的和正好是s
 * 第二题：输入一个正数，打印出所有和为s的连续整数序列
 * 用两个指针，进行移动
 * 测试用例：数组为空或无数据，数组只有一个数，数组有多个数但是找不到，数组找得到，
 * Created by oubin on 17-2-20.
 */
public class Ques41CertainSum {

    public static Map<Integer, Integer> getCertainSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums == null|| nums.length == 0) return map;

        int left = 0, right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] > target){
                right--;
            }else if (nums[left] + nums[right] < target){
                left++;
            }else if (nums[left] + nums[right] == target){
                map.put(nums[left], nums[right]);
                left++;
                right--;
            }
        }
        return map;
    }

    public static List<List<Integer>> getContinueSum(int target){
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 0) return result;

        int left = 1, right = 2;
        int sum = 3;
        while (left < (target + 1) / 2){
            if (sum < target){
                right++;
                sum += right;
            }else if (sum > target){
                sum -= left;
                left++;
            }else if (sum == target){
                addToList(left, right, result);
                right++;
                sum += right;
            }
        }
        return result;
    }

    private static void addToList(int left, int right, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++){
            list.add(i);
        }
        result.add(list);
    }


    public static void main(String[] args) {
        System.out.println(getContinueSum(25));
    }
}
