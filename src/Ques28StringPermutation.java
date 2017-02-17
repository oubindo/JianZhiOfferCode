import common.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 考虑：使用递归来解
 * 测试用例：空数组，数目为1，无相同元素，有相同元素
 * Created by oubin on 17-2-16.
 */
public class Ques28StringPermutation {

    public List<String> permutation(String str){
        List<String> result = new ArrayList<>();
        if (str != null && str.length() != 0){
            permutate(str.toCharArray(), 0, result);
        }
        return result;
    }

    private void permutate(char[] chars, int i, List<String> result) {
        if (i == chars.length - 1){
            result.add(String.valueOf(chars));
        }else {
            for (int j = i; j < chars.length; j++){
                if (j == i || chars[j] != chars[i]){
                    Util.swap(chars, i, j);
                    permutate(chars, i + 1, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        Ques28StringPermutation permutation = new Ques28StringPermutation();
        System.out.println(Arrays.toString(permutation.permutation("abc").toArray()));
    }

}
