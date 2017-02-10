import java.util.Stack;

/**
 * 利用两个栈实现队列的存取操作
 * Created by oubin on 17-2-10.
 */
public class Ques7TwoStackToQueue {
    Stack<Integer> input=new Stack();
    Stack<Integer> output=new Stack();

    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if(output.empty()){
            while(!input.empty())
                output.push(input.pop());
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty()&&output.empty();
    }
}
