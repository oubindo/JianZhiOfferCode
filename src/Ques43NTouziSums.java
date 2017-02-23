/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s，输入n，打印出s的所有可能的值出现的概率。
 * 考虑：对于这种后一个的结果基于前一种的结果的问题都可以使用递归和迭代求解。
 * 测试用例：target小于0。
 * Created by oubin on 17-2-21.
 */
public class Ques43NTouziSums {

    /**
     * 打印出可能性,使用递归法
     * @param target 色子个数
     * @param max  色子的最大值
     */
    public static void printProbility(int target, int max){
        if (target <= 0 || max <= 0) return;

        int maxnum = target * max;
        int[] sums = new int[maxnum - target + 1];
        probility(target, sums, max);
        double total = 1;
        for (int i = 0; i < target; i++){
            total *= max;
        }
        for (int i = target; i <= maxnum; i++){
            double ratio = sums[i - target] / total;
            System.out.printf("%-8.4f", ratio);
        }
    }

    private static void probility(int target, int[] sums, int max) {
        for (int i = 1; i <= max; i++){
            probility(target, target, sums, max, i);
        }
    }

    private static void probility(int number, int curr, int[] sums, int max, int sum) {
        if (curr == 1){
            sums[sum - number]++;
        } else {
            for (int i = 1; i <= max; i++){
                probility(number, curr - 1, sums, max, sum + i);
            }
        }
    }


    /**
     * 使用循环法求解，将中间数值保存下来
     * @param target 色子个数
     * @param max   色子最大值
     */
    public static void printProbility2(int target, int max){
        if (target <= 0 || max <= 0) return;

        int[][] sums = new int[2][target * max + 1];
        // 标记当前是哪个数组在使用中
        int flag = 0;
        // 抛出一个色子时的情况
        for (int i = 1; i <= max; i++){
            sums[flag][i] = 1;
        }
        for (int k = 2; k <= target; k++){
            // 如果抛出了k个骰子，那么和为[0, k-1]的出现次数为0,这个是为了修正之前的填写的信息
            for (int i = 0; i < k; i++){
                sums[1 - flag][i] = 0;
            }
            // 抛出k个骰子，所有和的可能
            for (int i = k; i <= max * target; i++){
                sums[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= max; j++){
                    // 统计出和为i的点数出现的次数
                    sums[1 - flag][i] += sums[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = 1;
        for (int i = 0; i < target; i++){
            total *= max;
        }
        int maxnum = target * max;
        for (int i = target; i <= maxnum; i++){
            double ratio = sums[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }

    }



    public static void main(String[] args) {
        printProbility(2, 4);
    }

}
