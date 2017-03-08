/** 不用加减乘除做加法：只能用位运算了，同时注意到可以通过异或确定value，通过相与确定进位，这就比较容易了。
 * Created by oubin on 17-3-8.
 */
public class Ques47Add {

    public static int add(int a, int b){
        int carry = 0;
        int sum = 0;
        do{
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (b != 0);
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        add(-1, 5);
        add(44, 332);
        add(4, 0);
        add(0, 19);
    }

}
