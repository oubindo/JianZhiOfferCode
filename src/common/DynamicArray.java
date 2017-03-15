package common;

/**
 * Created by oubin on 17-3-15.
 */
public class DynamicArray {
    private Heap<Integer> max;
    private Heap<Integer> min;
    public DynamicArray() {
        max = new Heap<>(new IncComparator());
        min = new Heap<>(new DecComparator());
    }
    /**
     * 插入数据
     *
     * @param num 待插入的数据
     */
    public void insert(Integer num) {
        // 已经有偶数个数据了（可能没有数据）
        // 数据总数是偶数个时把新数据插入到小堆中
        if ((min.size() + max.size()) % 2 == 0) {
            // 大堆中有数据，并且插入的元素比大堆中的元素小
            if (max.size() > 0 && num < max.getTop()) {
                // 将num加入的大堆中去
                max.add(num);
                // 删除堆顶元素，大堆中的最大元素
                num = max.deleteTop();
            }
            // num插入到小堆中，当num小于大堆中的最大值进，
            // num就会变成大堆中的最大值，见上面的if操作
            // 如果num不小于大堆中的最大值，num就是自身
            min.add(num);
        }
        // 数据总数是奇数个时把新数据插入到大堆中
        else {
            // 小堆中有数据，并且插入的元素比小堆中的元素大
            if (min.size() > 0 && num > min.getTop()) {
                // 将num加入的小堆中去
                min.add(num);
                // 删除堆顶元素，小堆中的最小元素
                num = min.deleteTop();
            }
            // num插入到大堆中，当num大于小堆中的最小值进，
            // num就会变成小堆中的最小值，见上面的if操作
            // 如果num不大于大堆中的最小值，num就是自身
            max.add(num);
        }
    }
    public double getMedian() {
        int size = max.size() + min.size();
        if (size == 0) {
            throw new RuntimeException("No numbers are available");
        }
        if ((size & 1) == 1) {
            return min.getTop();
        } else {
            return (max.getTop() + min.getTop()) / 2.0;
        }
    }
}
