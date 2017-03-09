/**
 * Created by oubin on 17-3-9.
 */
public class Ques53Matcher {

    public static boolean match(String pattern, String str){
        if (pattern == null || str == null) return false;
        char[] pa = pattern.toCharArray();
        char[] st = str.toCharArray();
        return matchHelper(pa, st, 0, 0);
    }

    private static boolean matchHelper(char[] pattern, char[] str, int pCurr, int sCurr) {
        if ((pCurr == pattern.length - 1) && (sCurr == str.length - 1)){
            return true;
        }
        if ((pCurr == pattern.length - 1) && (sCurr != str.length - 1)){
            return false;
        }
        if (pattern[pCurr + 1] == '*'){
            if (pattern[pCurr] == str[sCurr] || (pattern[pCurr] == '.' && sCurr != str.length)){
                return matchHelper(pattern, str, pCurr + 2, sCurr + 1)  // 匹配一个
                        || matchHelper(pattern, str, pCurr, sCurr + 1)  // 匹配多个
                        || matchHelper(pattern, str, pCurr + 2, sCurr); // 无匹配
            } else {
                return matchHelper(pattern, str, pCurr + 2, sCurr);   // 无匹配
            }
        }
        if (pattern[pCurr] == str[sCurr] || (pattern[pCurr] == '.' && sCurr != str.length)){
            return matchHelper(pattern, str, pCurr + 1, sCurr + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("a.ba","aaa"));
    }

}
