/**
 * 输出从1到最大的n位数。
 * 考虑：大数的情况，int不足以放下，使用string来存放
 * 测试用例：
 *
 * Created by oubin on 17-2-13.
 */
public class Ques12PrintOneToMax {

    // 第一种方法：利用循环和递归来进行处理，事件复杂度是O(n2)
    public void print(int n){
        if(n <= 0) return;
        int[] arr = new int[n];
        printOneToNMax(0, arr);
    }

    private void printOneToNMax(int start, int[] array) {
        // 说明所有的数据排列选择已经处理完了
        if(start >= array.length){
            printArray(array);
        }else{
            for(int i = 0; i <= 9; i++){
                array[start] = i;
                printOneToNMax(start + 1, array);
            }
        }
    }

    private void printArray(int[] arr) {
        int index = 0;
        while(index < arr.length && arr[index] == 0){
            index++;
        }
        for(int i = index; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    // 第二种方法：通过判断是否有进位，如果有进位了就结束了
    public void print2(int n){
        if(n <= 0) return;
        // 创建一个长度为n的数组
        int[] arr = new int[n];
        // 为数组元素赋初始值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        // 求结果，如果最高位没有进位就一直进行处理
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    private int addOne(int[] arr) {
        int carry = 1;
        int index = arr.length;
        do{
            index--;
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] %= 10;
        }while (index > 0 && carry != 0);

        if(index == 0 && carry > 0){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args){
        Ques12PrintOneToMax print = new Ques12PrintOneToMax();
        print.print2(3);
    }

}
