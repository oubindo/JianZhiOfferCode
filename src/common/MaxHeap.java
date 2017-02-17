package common;

import java.util.List;

/**
 * Created by oubin on 17-2-12.
 */
public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int[] heap) {
        this.heap = heap;
        this.size = heap.length;
    }

    // 从后到前进行最大化操作
    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapDown(i);
        }
    }

    // 找到父节点及双子结点中的最大值，两者交换，再递归去最大化堆 ----------- 这其实就是下沉操作，删除也是下沉操作，而插入是上浮操作
    private void heapDown(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < size && heap[l] > heap[i])
            largest = l;
        else
            largest = i;
        if (r < size && heap[r] > heap[largest])
            largest = r;
        if (largest == i || largest >= size) {
            return;
        }
        int tmp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = tmp;
        heapDown(largest);
    }

    public void heap_sort() {
        for (int i = 0; i < heap.length; i++) {
            int temp = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = temp;
            size--;
            heapDown(0);
        }
    }

    private int left(int i) {
        return 2 * (i + 1) - 1;
    }

    private int right(int i) {
        return 2 * (i + 1);
    }


    /**
     * 删除数组index的元素，
     * @param heap 已经排好序的最大堆，注意这里和我们前面的代码是矛盾的，如果要改必须将前面都用ArrayList来实现，不打算改了。
     * @param index 要删除的最大堆的某一index
     */
    public void delete(List<Integer> heap, int index){
        heap.set(index,heap.get(heap.size() - 1));
        heapDown(index);
        heap.remove(heap.size() - 1);
    }

    /**
     * 向堆中插入某值,将值放在最后一位，然后将这个值上浮，上浮就是将这个值和父节点比较大小，如果比父节点大，那么需要swap
     * @param heap
     * @param num
     */
    public void insert(List<Integer> heap, int num){
        // ..
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        MaxHeap heap = new MaxHeap(array);
        System.out.println("执行最大堆化前堆的结构：");
        printHeapTree(heap.heap);
        heap.buildMaxHeap();
        System.out.println("执行最大堆化后堆的结构：");
        printHeapTree(heap.heap);
        heap.heap_sort();
        System.out.println("执行堆排序后数组的内容");
        printHeap(heap.heap);

    }


    private static void printHeapTree(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int k = i - 1; k < 2 * (i) - 1 && k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
