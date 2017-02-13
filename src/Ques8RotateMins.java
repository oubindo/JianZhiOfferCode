import java.util.Arrays;

/**
 * Created by oubin on 17-2-12.
 */
public class Ques8RotateMins {

    public static int findMinInRotateNums(int[] array) {
        int length = array.length;
        if (length <= 1) return array[0];
        int left = 0, right = length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if(array[left] == array[mid] && array[right] == array[mid])
                return minOrder(array,left,right);
            if (array[mid] > array[left]) {
                left = mid;
            }else if (array[mid] < array[right]) {
                right = mid;
            }

        }
        return array[mid];
    }

    private static int minOrder(int[] array, int left, int right) {
        int result = array[left];
        for(int i = left + 1; i <= right; i++){
            if(result > array[i]){
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = Ques8RotateMins.findMinInRotateNums(new int[]{7, 8, 1, 2, 3, 4, 5, 6});
        System.out.println(result);

    }


}
