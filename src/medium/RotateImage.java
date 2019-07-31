package medium;

/**
 * RotateImage
 *
 * @author black
 * @date 2019-07-26
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] test = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotate(test);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int swap = 0;
        int lastValue = 0;
        int swapIndex = 0;
        int count = 0;
        int rowIndex = 0;
        int columnIndex = 0;
        int loopLength = rowLength / 2;
        for (int i = 0; i < loopLength; i++) {
            for (int j = i; j < columnLength - i - 1; j++) {
                rowIndex = i;
                columnIndex = j;
                lastValue = matrix[i][j];
                count = 0;
                while (count != 4) {
                    swapIndex = rowIndex;
                    rowIndex = columnIndex;
                    columnIndex = rowLength - swapIndex - 1;

                    swap = matrix[rowIndex][columnIndex];
                    matrix[rowIndex][columnIndex] = lastValue;
                    lastValue = swap;
                    count++;
                }
            }
        }
    }
}
