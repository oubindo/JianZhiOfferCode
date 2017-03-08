import java.util.Arrays;
import java.util.Scanner;

/**
 * 计算1+2+....+n的值，要求不能使用乘除，if else while for switch case 及条件判断语句
 * 考虑：1.利用构造函数求解
 * Created by oubin on 17-3-2.
 */
public class Ques46Increase {
    private static int num = 0;
    private static int sum = 0;

    public Ques46Increase() {
        num++;
        sum += num;
        System.out.println(num + "  " + sum);
    }

    public static void main(String[] args){
        Ques46Increase i1 = new Ques46Increase();
        Ques46Increase i2 = new Ques46Increase();
        Ques46Increase i3 = new Ques46Increase();
        Ques46Increase i4 = new Ques46Increase();
        Ques46Increase i5 = new Ques46Increase();
    }


}
