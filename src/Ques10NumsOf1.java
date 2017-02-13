/**
 * Created by oubin on 17-2-12.
 */
public class Ques10NumsOf1 {

    // 每一位把数右移
    public int numsOfOne(int n){
        int sum = 0;
        for(int i = 0; i < 32;i++){
            if(((n >> 1) & 0x1) > 0) sum++;
        }
        return sum;
    }

    /**
     * 这种解法更加先进，可以直接只运算1数字的个数次。利用减一后再与一下可以少一个1的原理。
     * @param n
     * @return
     */
    public int numsOfOne2(int n){
        int count = 0;
        while(n > 0){
            ++ count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args){
        Ques10NumsOf1 numsOf1 = new Ques10NumsOf1();
        System.out.println(numsOf1.numsOfOne(-2));
        System.out.println(numsOf1.numsOfOne2(-2));
    }

}
