/**
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中任意一个开始，每一步可以在矩阵中向左右上下移动一个。如果已经进入过，那么下次不能再进入。
 * 考虑：回溯法.对于每个点进行一次遍历，判断是否可以以这个为首节点，找到之后从上下左右进行递归遍历，找不到就回到原来的位置
 * Created by oubin on 17-3-17.
 */
public class Ques66PathInMatrix {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        // 参数校验
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        // 变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // 记录结果的数组，
        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,
                                       boolean[] visited, int row, int col, int[] pathLength) {
        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 判断位置是否合法
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
    }

    public static void main(String[] args) {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");// true

        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEM".toCharArray()) + "[true]");// true
    }

}
