import common.RandomListNode;
import common.TestInstance;

import java.util.HashMap;
import java.util.Random;

/**
 * 复制一个复杂链表。结点有一个next指针和随意指针。
 * 考虑：解法1：用一个map记录下来随意指针的key和value。解法2：把复制的节点直接放在原节点后面
 * 测试用例：空head，只有一个结点，正常链表
 * Created by oubin on 17-2-15.
 */
public class Ques26CopyComplexArray {

    public RandomListNode copyComplexArray1(RandomListNode root){
        if (root == null) return null;

        RandomListNode helper = root;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head = new RandomListNode(root.label);
        RandomListNode curr = head;
        map.put(root, head);
        root = root.next;
        while (root != null){
            RandomListNode currNext = new RandomListNode(root.label);
            map.put(root, currNext);
            curr.next = currNext;
            curr = curr.next;
            root = root.next;
        }
        while (helper != null){
            RandomListNode value = map.get(helper);
            if(helper.random != null) value.random = map.get(helper.random);
            helper = helper.next;
        }
        return head;
    }

    public RandomListNode copyComplexArray2(RandomListNode root){
        if (root == null) return null;

        RandomListNode temp = root;
        while (temp != null){
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = root;
        while (temp != null){
            RandomListNode node = temp.next;
            if (temp.random != null){
                node.random = temp.random.next;
            }
            temp = node.next;


//            if (temp.random != null) temp.next.random = temp.random.next;
//            temp = temp.next.next;
        }
        temp = root;
        RandomListNode result = root.next;
        RandomListNode clone = result;
        while (temp != null){
            temp.next = clone.next;
            temp = temp.next;
            if (temp == null) break;
            clone.next = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Ques26CopyComplexArray array = new Ques26CopyComplexArray();
        array.copyComplexArray1(TestInstance.getRandomList());
    }

}
