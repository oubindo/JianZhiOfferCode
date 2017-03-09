import java.util.Arrays;

/**
 * 构建乘积数组，不能使用除法。乘积数组就是一个数组中除了这个数以外都要乘的数组。
 * Created by oubin on 17-3-8.
 */
public class Ques52Multiply {

    public static double[] multiply(double[] data){
        if (data == null || data.length == 0) return null;

        double[] result = new double[data.length];

        result[0] = 1;
        for (int i = 1; i < data.length; i++){
            result[i] = result[i - 1] * data[i - 1];
        }

        double temp = 1;
        for (int i = data.length - 2; i >= 0; i--){
            temp *= data[i + 1];
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiply(new double[]{1,2,3,4,5})));
    }

}
