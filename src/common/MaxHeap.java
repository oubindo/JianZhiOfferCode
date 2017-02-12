package common;

/**
 * Created by oubin on 17-2-12.
 */
public class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int[] heap){
        this.heap = heap;
        this.size = heap.length;
    }

    public void buildMaxHeap(){
        for(int i = size / 2 - 1; i >= 0; i--){
            maxify(i);
        }
    }

    private void maxify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if(l<size&&heap[l]>heap[i])
            largest=l;
        else
            largest=i;
        if(r<size&&heap[r]>heap[largest])
            largest=r;
        if(largest == i || largest >= size){
            return;
        }
        int tmp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = tmp;
        maxify(largest);
    }

    public void heap_sort(){
        for(int i = 0; i < heap.length; i++){
            int temp = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = temp;
            size--;
            maxify(0);
        }
    }

    private int left(int i) {
        return 2 * (i + 1) - 1;
    }

    private int right(int i){
        return 2 * (i + 1);
    }

    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,4,7,8,9,10,14,16};
        MaxHeap heap=new MaxHeap(array);
        System.out.println("执行最大堆化前堆的结构：");
        printHeapTree(heap.heap);
        heap.buildMaxHeap();
        System.out.println("执行最大堆化后堆的结构：");
        printHeapTree(heap.heap);
        heap.heap_sort();
        System.out.println("执行堆排序后数组的内容");
        printHeap(heap.heap);

    }


    private static void printHeapTree(int[] array)
    {
        for(int i=1;i<array.length;i=i*2)
        {
            for(int k=i-1;k<2*(i)-1&&k<array.length;k++)
            {
                System.out.print(array[k]+" ");
            }
            System.out.println();
        }
    }
    private static void printHeap(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }



}
