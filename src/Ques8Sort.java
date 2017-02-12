import java.util.Arrays;

/**
 * 各种排序算法的比较
 * Created by oubin on 17-2-10.
 */
public class Ques8Sort {

    // 冒泡排序：最好O(n),最差O(n2),空间O(1)
    // 改进：设置一个flag，如果一趟无元素交换就结束循环
    public void bubble_sort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // 插入排序:time O(n2),space O(1). 可以使用交换，也可以使用填数，下面使用填数
    public void insert_sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }

    // 选择排序：time O(n2),space O(1)
    public void select_sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            swap(nums, min, i);
        }
    }

    // 希尔排序，插入排序的改进版。步长的选择是希尔排序的重要部分。
    // 只要最终步长为1任何步长序列都可以工作。算法最开始以一定的步长进行排序。
    // 然后会继续以一定步长进行排序，最终算法以步长为1进行排序。当步长为1时，算法变为插入排序，
    // 这就保证了数据一定会被排序。
    // time O(nlgn)-O(n2)
    public void shell_sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int gap = nums.length >> 1;
        for (; gap > 0; gap >>= 1) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i - gap;
                for (; j >= 0 && nums[j] > temp; j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = temp;
            }
        }
    }

    // 归并排序:递归版本 time o(nlgn) space O(n)
    public void merge_sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        merge_sortHelper(nums, 0, nums.length - 1);
    }

    private void merge_sortHelper(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sortHelper(nums, start, mid);
            merge_sortHelper(nums, mid + 1, end);
            merge_array(nums, start, mid, end);
        }
    }

    private void merge_array(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        int resultIndex = start;
        int i = start, j = mid + 1;
        /*while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[resultIndex++] = nums[i++];
            } else {
                temp[resultIndex++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[resultIndex++] = nums[i++];
        }
        while (j <= end) {
            temp[resultIndex++] = nums[j++];
        }*/
        for(int m = start; m <=end; m++){
            if(i > mid){
                temp[m] = nums[j++];
            }else if(j > end){
                temp[m] = nums[i++];
            }else if(nums[i] < nums[j]){
                temp[m] = nums[i++];
            }else{
                temp[m] = nums[j++];
            }
        }

        for(int k = start; k <= end; k++){
            nums[k] = temp[k];
        }
    }

    // 归并排序：迭代版本.迭代版本思想和递归版本相反，是先两两配对，然后在进行比较，再合并
    public void merge_sort2(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;
        int span = 2, i;
        while (span <= length) {
            i = 0;
            while (i + span <= length) {
                merge_array(nums, i, i + span / 2 - 1, i + span - 1);
                i += span;
            }
            merge_array(nums, i, i + span / 2 - 1, length - 1);
            span *= 2;
        }
        merge_array(nums, 0, span / 2 - 1, length - 1);
    }

    /* 堆排序：堆排序基于最大堆(每个双亲节点的值都比子女大)或者最小堆，可以视为一种完全二叉树，即除了最后一层其他的都是填满的。
    所以有 Parent(i) = i/2, left(i) = 2*i，right(i) = 2*i + 1，所以对于一个n元素的数组而言 ，我们创建嘴大堆的过程就应该在1-n/2的元素上进行
    见MaxHeap。time:O(nlgn)  space:O(1)
    */

    /**
     * 快速排序，重要的是这个partition方法完成的事.快速排序time:O(nlgn) space:O(1)
     * 改进措施：在partition的时候进行三个数的比较，取前后中三个数比较一下，选择三者的中值作为枢纽。
     * @param nums
     */
    public void quick_sort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        quickSortHelper(nums, 0, nums.length - 1);
    }

    // 这里的重点是递归左边的end是pivot-1而不是pivot，不然的话当pivot = right,且nums[pivot] = nums[left]时两个相等的时候
    private void quickSortHelper(int[] nums, int left, int right) {
        if(left < right){
            int pivot = partition(nums, left, right);  // 将数组分成两部分
            quickSortHelper(nums, left, pivot - 1);    // 递归排序左部分
            quickSortHelper(nums, pivot + 1, right);   // 递归排序右部分
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] > pivot) --right;
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot) ++left;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }


    public static void main(String[] args) {
        Ques8Sort sort = new Ques8Sort();
        int[] nums = new int[]{1, 19,3, 0, 5, 2,15,22, 7, 8, 2, 1,22};
        int[] nums1 = new int[]{1, 3, 0, 5, 2, 7,8,2};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{4, 3, 2, 1};
        //sort.bubble_sort(nums);
        //sort.insert_sort(nums);
        //sort.select_sort(nums);
        //sort.shell_sort(nums);
        //sort.merge_sort(nums);
        //sort.merge_sort2(nums);
        //sort.merge_sort2(nums2);
        //sort.merge_sort2(nums3);
        sort.quick_sort(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));

    }


}
