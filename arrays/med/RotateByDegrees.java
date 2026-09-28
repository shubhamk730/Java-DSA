//Rotate by 90 degrees
package arrays.med;

public class RotateByDegrees {

    private void reverseArray(int[][] matrix, int row) {
        int left = 0, right = matrix[0].length - 1;

        while( left <= right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }

    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
    
        // 1. Transpose the matrix
        // traverse only upper right element, if you travel all reverse will be reversed.

        for(int i = 0; i <= n-2; i++) {
            for(int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row
        for (int i = 0; i < n; i++) {
            reverseArray(matrix, i);
        }

    
    }

    public static void main(String[] args) {
        
    }

}

