package common;

import java.util.Comparator;

/**
 * Created by oubin on 17-3-15.
 */
public class DecComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
