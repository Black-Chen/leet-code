package medium;

import java.util.HashSet;

/**
 * SetMatrixZeros
 *
 * @author black
 * @date 2019-08-30
 */
public class SetMatrixZeros {

    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroColumns.add(j);
                }
            }
        }
        for (Integer row : zeroRows) {
            matrix[row] = new int[matrix[row].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (Integer column : zeroColumns) {
                matrix[i][column] = 0;
            }
        }
    }
}
