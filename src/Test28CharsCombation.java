import java.util.ArrayList;
import java.util.List;

/**
 * 求字符的组合，比如输入a,b,c,输入a b c ab ac bc abc
 * 考虑：求n个字符的长度为m的组合时，分为第一个字符和后面部分。如果组合中包含第一个字符，则求n - 1个字符的长度为m - 1的组合
 * 否则求n-1个字符的长度为m的组合
 * 测试用例：空，空，单一，多字符
 * Created by oubin on 17-2-16.
 */
public class Test28CharsCombation {

    public List<String> charCombation(char[] chars){
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        if (chars != null && chars.length != 0){
            for (int i = 1; i <= chars.length; i++){
                charCombate(chars, 0, i, result, builder);
            }
        }
        return result;
    }

    private void charCombate(char[] chars, int start, int i, List<String> result, StringBuilder builder) {
        StringBuilder temp = new StringBuilder(builder.toString());
        // 当i为0时，说明已经找到了所有需要的点
        if (i == 0){
            System.out.println(temp.toString());
            result.add(temp.toString());
            return;
        }

        // 对于这种选不选择的问题就使用先加上去再删掉的方法来处理了
        if (start < chars.length) {
            temp.append(chars[start]);
            charCombate(chars, start + 1, i - 1, result, temp);
            temp.deleteCharAt(temp.length() - 1);
            charCombate(chars, start + 1, i, result, temp);
        }
    }

    public static void main(String[] args) {
        Test28CharsCombation combation = new Test28CharsCombation();
        combation.charCombation(new char[]{'a','b','c','d'});
    }

}
