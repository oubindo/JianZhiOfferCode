import java.util.*;

/**
 * 给出数组和滑动窗口的大小，求出所有的滑动窗口的最大值。
 * Created by oubin on 17-3-15.
 */
public class Ques65SlipWindowMaxium {

    public static List<Integer> windowMaxium(int[] nums, int winSize){
        List<Integer> windowMax = new LinkedList<>();
        if (nums == null || nums.length == 0 || winSize <= 0) return windowMax;

        Deque<Integer> idx = new LinkedList<>();
        List<Integer> data = arrayToCollection(nums);
        // 窗口没被填满时找最大值的索引
        for (int i = 0; i < winSize && i < data.size(); i++){
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())){
                idx.removeLast();
            }
            idx.addLast(i);
        }
        for (int i = winSize; i < data.size(); i++){
            // 第一个窗口的最大值保留
            windowMax.add(data.get(idx.getFirst()));
            // 如果索引对应的值比之前存储的值的索引值对应的值大或者相等，就删除之前存储的值。
            while (!idx.isEmpty() && data.get(i) > data.get(idx.getLast())){
                idx.removeLast();
            }
            // 删除已经滑出窗口的数据对应的下标
            if (!idx.isEmpty() && idx.getFirst() <= (i - winSize)){
                idx.removeFirst();
            }
            // 可能的最大下表索引入队。
            idx.addLast(i);
        }
        windowMax.add(data.get(idx.getFirst()));
        return windowMax;
    }

    private static List<Integer> arrayToCollection(int[] array) {
        List<Integer> result = new LinkedList<>();
        if (array != null) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        windowMaxium(new int[]{2,3,4,2,6,2,5,1},3);
    }

}
