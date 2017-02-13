/**
 * 求base的exponent次方，不使用库函数，不考虑大数问题
 * 考虑：次方为负或0，
 * 用例：
 * Created by oubin on 17-2-13.
 */
public class Ques11Power {
    public double power(double base, int exponent) throws Exception{
        if(equal(base, 0.0) && exponent < 0) throw new Exception("base can not be 0 when exponent < 0");

        double result = 1.0;
        for(int i = 0; i < Math.abs(exponent); i++){
            result *= base;
        }
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }

    public double power2(double base, int exponent) throws Exception{
        if(equal(base, 0.0) && exponent < 0) throw new Exception("base can not be 0 when exponent < 0");
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        double result = power2(base, exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1) result *= base;

        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
    }

    public boolean equal(double a, double b){
        if((a - b > - 0.000001) && (a - b < 0.000001)){
            return true;
        }else return false;
    }

    public static void main(String[] args) throws Exception{
        Ques11Power power = new Ques11Power();
        System.out.println(power.power(-2,2));
        System.out.println(power.power2(-2,2));
    }

}
