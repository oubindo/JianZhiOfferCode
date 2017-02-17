import java.util.Arrays;

/**
 * 输入一个数字n，求1到n这n个整数中的十进制表示中1出现的次数
 * 考虑：递归，但是如何使用递归还需要我来考虑清楚
 * 测试用例：负数，0,1，正常数字，大数字    性能，功能，边界值测试
 * Created by oubin on 17-2-17.
 */
public class Ques32OneOccurTimes {

    public int getOneOccurTimes(int n){
        if (n <= 0) return 0;
        char[] intChars = String.valueOf(n).toCharArray();
        return oneOccurTimes(intChars, 0);
    }

    private int oneOccurTimes(char[] nums, int curr) {
        if (nums == null || curr >= nums.length || curr < 0){
            return 0;
        }
        // 当前要处理的数
        int first = nums[curr];
        // 要处理的数字的位数
        int length = nums.length - curr;
        // 如果只有一位且这位为0
        if (length == 1 && first == 0) return 0;
        if (length == 1 && first != 0) return 1;
        // 最高数位中的数
        int numsFirstDigit = 0;
        // 如果最高位不是1，如21345，那么出现的就在[10000,19999]
        if (first > 1){
            numsFirstDigit = powerBase10(length - 1);
        }
        // 如果最高位是1，如12345，在[2346,12345]中，最高位出现的只有在[10000,12345]中，共2345+1个
        else if (first == 1){
            numsFirstDigit = atoi(nums, curr+1) + 1;
        }
        int numOtherDigits = first * (length -1) * powerBase10(length - 2);
        int numsRecursive = oneOccurTimes(nums, curr + 1);
        return numsFirstDigit + numOtherDigits + numsRecursive;
    }

    private int atoi(char[] nums, int i) {
        int result = 0;
        for (int j = i; j < nums.length; j++){
            result = result * 10 + nums[j];
        }
        return result;
    }

    // 求10的n次方
    private int powerBase10(int i) {
        int result = 1;
        for (int j = 0; j < i; j++){
            result = result * 10;
        }
        return result;
    }
}
