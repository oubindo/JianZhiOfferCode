/**
 * Created by oubin on 17-2-12.
 */
public class Ques9Fibonacci {

    public int fibonacci(int target){
        if(target <= 0) return 0;
        if(target == 1) return 1;
        int pre = 0, curr = 1,next = 0;
        for(int i = 2; i <= target; i++){
            next = pre + curr;
            pre = curr;
            curr = next;
        }
        return next;
    }

    // 斐波拉契数列的另外一种形式
    public int jumpFloor(int n){
        if(n <= 1) return 1;
        if(n == 2) return 2;
        return jumpFloor(n-2)+jumpFloor(n-1);
    }


    // 0 1 1 2 3 5 8 13 21
    public static void main(String[] args){
        Ques9Fibonacci fibonacci = new Ques9Fibonacci();
        fibonacci.fibonacci(7);
    }


}
