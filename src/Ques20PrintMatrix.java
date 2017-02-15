/**
 * 输入一个矩阵，按照从外到里的顺序依次打印好每一个数字。
 * 考虑：如何进行多重边界的判断
 *
 * Created by oubin on 17-2-15.
 */
public class Ques20PrintMatrix {

    public void printMatrix(int[][] matrix){
        if (matrix == null) return;
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        while (column > start * 2 && row > start * 2){
            printNumsInCircle(matrix, start, row, column);
            ++start;
        }

    }

    private void printNumsInCircle(int[][] matrix, int start, int row, int column) {
        int endX = column - 1 - start;
        int endY = row - 1 - start;

        for (int i = start; i <= endX; i++){
            System.out.println(matrix[start][i]);
        }

        if (start < endY){
            for (int i = start + 1;i <= endY ;i++){
                System.out.println(matrix[i][endX]);
            }
        }

        if(start < endX && start < endY){
            for (int i = endX - 1; i >= start; i--){
                System.out.println(matrix[endY][i]);
            }
        }

        if(start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1; --i){
                System.out.println(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args){
        Ques20PrintMatrix matrix = new Ques20PrintMatrix();
        matrix.printMatrix(new int[][]{{1}});
    }

}