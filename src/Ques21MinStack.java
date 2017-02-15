import java.util.Stack;

/**
 * 定义栈的数据结构，在该类型中实现一个能够得到栈的最小元素的min函数
 * 考虑：跟栈有关的问题可以考虑用多个栈来实现，这里的话就可以使用两个栈来实现。
 * 测试用例：无元素，正常push，pop，min；弹出元素：是最小值，不是最小值；压入元素：比之前最小值小，大
 * Created by oubin on 17-2-15.
 */
public class Ques21MinStack {
    private Stack<Integer> numStack;
    private Stack<Integer> minStack;
    private int minNum = Integer.MAX_VALUE;

    public Ques21MinStack(){
        numStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int i){
        numStack.push(i);
        minNum = minNum > i ? i : minNum;
        minStack.push(minNum);

    }

    public int pop(){
        minStack.pop();
        return numStack.pop();
    }

    public int min(){
        if(!minStack.isEmpty())
        return minStack.peek();
        else return 0;
    }

    public void clear(){
        numStack.clear();
        minStack.clear();
    }

    public static void main(String[] args){
        Ques21MinStack minStack = new Ques21MinStack();
        minStack.push(5);
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        ////////////////////
        minStack.push(1);
        minStack.push(2);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.clear();


    }

}
