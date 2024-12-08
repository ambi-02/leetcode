class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    // Check if the matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty matrix case
        }

        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        int row=0;
        int col=m-1;

        while(row<n && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) row++;
            else col--;
        }
        return false;
    }
}