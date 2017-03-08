import common.ListNode;

/**
 * 解法：1.用链表来模拟这个过程   2. 用数学方程f(n,m) = [f(n - 1,m) + m] % n when n > 1
 * Created by oubin on 17-3-1.
 */
public class Ques45LastNumInCircle {

    public static int lastNum(int n, int m){
        if (n < 1 || m < 1){
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++){
            last = (last + m) % i;
        }
        return last;
    }
}
