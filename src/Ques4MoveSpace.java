/**
 * Created by oubin on 17-2-9.
 */
public class Ques4MoveSpace {

    public static void moveSpace(char[] strChars, int total){
        //step1 边界判断
        if(strChars == null || strChars.length == 0){
            return;
        }
        int length = strChars.length;
        int originLength = 0;
        int numOfBlank = 0;
        int i = 0;
        while(strChars[i] != '\0'){
            ++ originLength;
            if(strChars[i] == ' '){
                ++ numOfBlank;
            }
            ++ i;
        }
        int newlength = originLength + numOfBlank * 2;
        if(newlength > total){
            return;
        }

        int indexOfOld = originLength;
        int indexOfNew = newlength;
        while(indexOfOld >= 0 && indexOfNew > indexOfOld){
            if(strChars[indexOfOld] == ' '){
                strChars[indexOfNew --] = '0';
                strChars[indexOfNew --] = '2';
                strChars[indexOfNew --] = '%';
            }else{
                strChars[indexOfNew --] = strChars[indexOfOld];
            }
            indexOfOld --;
        }
    }

}
