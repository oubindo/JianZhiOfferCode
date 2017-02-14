import common.Util;

/**
 * 调整数组顺序使奇数位于偶数之前
 * 考虑：双指针交换
 * 测试用例：空数组，空值，无奇数或无偶数，正常
 * Created by oubin on 17-2-14.
 */
public class Ques14Reorder {

    public void reorder(int[] aray) {
        if (aray == null || aray.length <= 1) {
            return;
        }
        int first = 0;
        int last = aray.length - 1;
        while (first < last) {
            while (first < last && function(aray,first)){
                first++;
            }
            while (last > first && !function(aray,last)) {
                last--;
            }
            Util.swap(aray, first, last);
            first++;
            last--;
        }
    }

    public boolean function(int[] nums,int n){
        return (nums[n] & 0x1) == 0;
    }
}
