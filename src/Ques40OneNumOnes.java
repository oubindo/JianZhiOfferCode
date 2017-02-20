import java.util.Arrays;

/**
 * 一个整型数组中除了两个数字之外，其他的数字都粗线了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n),空间复杂度是O(1)
 * Created by oubin on 17-2-20.
 */
public class Ques40OneNumOnes {

    public static int[] findTwoNums(int[] nums){
        if (nums == null || nums.length == 0){
            return new int[0];
        }

        // 先对所有数做异或，去掉相同的数
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        // 找到最右边的1的位置，我们需要这个位置来做判断，因为它既然是1，就一定不会是两个数都有值，我们就可以根据这个特性将原数组分为两个小数组，每个
        // 小数组中都有一个单一的数，再把这两个数组分别进行异或，就能得到唯一的那个数了。
        int index = findRightesOne(sum);

        int num1 = 0;
        int num2 = 0;
        for (int num : nums){
            if (isBitOfOne(num, index)){
                num1 ^= num;
            }else{
                num2 ^= num;
            }
        }
        return new int[]{num1,num2};
    }

    private static boolean isBitOfOne(int num, int index) {
        num >>= index;
        return (num & 1) == 1;
    }

    private static int findRightesOne(int sum) {
        int index = 0;
        while (((sum & 1) == 0) && index < 32){
            sum >>= 1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoNums(new int[]{4, 4, 3, 3, 2, 5, 5, 6, 6})));
    }

}
