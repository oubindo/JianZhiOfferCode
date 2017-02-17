/**
 * 丑数是只包含因子2,3,5的数.
 * Created by oubin on 17-2-17.
 */
public class Ques34UglyNum {

    public static int getUglyNum(int n){
        if (n <= 0) return 0;

        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int curr = 1;
        int multi2Index = 0;
        int multi3Index = 0;
        int multi5Index =0;

        while (curr < n) {
            int min = min(uglyNums[multi2Index] * 2, uglyNums[multi3Index] * 3, uglyNums[multi5Index] * 5);
            uglyNums[curr] = min;
            System.out.println(min);
            while (uglyNums[multi2Index] * 2 <= uglyNums[curr])
                multi2Index++;
            while (uglyNums[multi3Index] * 3 <= uglyNums[curr])
                multi3Index++;
            while (uglyNums[multi5Index] * 5 <= uglyNums[curr])
                multi5Index++;
            curr++;
        }
        return uglyNums[n - 1];
    }

    public static int min(int a, int b, int c){
        return a > b ? (b < c ? b : c) : (a < c ? a : c);
    }

    public static void main(String[] args) {
        getUglyNum(15);
    }
}
