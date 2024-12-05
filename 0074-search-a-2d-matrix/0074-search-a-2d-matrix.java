public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check if the matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty matrix case
        }

        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        // Apply binary search:
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m; // Calculate the row index
            int col = mid % m; // Calculate the column index

            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return false; // Target not found
    }
}