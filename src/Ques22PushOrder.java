import java.util.Stack;

/**
 * 输入两个整数系列，第一个序列表示压入顺序，判断第二个序列是否弹出顺序
 * 考虑：压入的顺序是固定的，但是弹出的顺序是可以变的。
 * 测试用例：数组为空，数据个数不一样，数组只有一个数字
 * 错误体会：一定要想清楚循环的结束条件和变化条件
 * Created by oubin on 17-2-15.
 */
public class Ques22PushOrder {

    public boolean isStackPopOrder(int[] pushOrder, int[] popOrder){
        if(pushOrder == null || popOrder == null) return false;
        if(pushOrder.length != popOrder.length) return false;

        int length = pushOrder.length;
        int pushIndex = 0, popIndex = 0;
        boolean result = false;

        Stack<Integer> stack = new Stack<>();
        /*stack.push(pushOrder[pushIndex++]);
        while (!stack.isEmpty() || popIndex < length){
            if (pushIndex > length) return false;
            if (popOrder[popIndex] != stack.peek() && pushIndex < length - 1){
                stack.push(pushOrder[pushIndex++]);
            }else{
                if (pushIndex == length) return false;
                popIndex++;
                stack.pop();
            }
        }*/
        while (popIndex < length){
            while (stack.isEmpty() || stack.peek() != popOrder[popIndex]){
                if (pushIndex == length) break;
                stack.push(pushOrder[pushIndex++]);
            }
            if (stack.peek() != popOrder[popIndex])
                break;
            stack.pop();
            popIndex++;
        }
        if (stack.empty() && popIndex == length)
            result = true;
        return result;
    }

    public static void main(String[] args){
        Ques22PushOrder order = new Ques22PushOrder();
        int[] input = new int[]{1,2,3,4,5};
        int[] output = new int[]{4,5,3,2,1};

        System.out.println(order.isStackPopOrder(input, output));
    }


}
