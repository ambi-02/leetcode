public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length; // number of rows
        int n = mat[0].length; // number of columns
        int left = 0, right = n - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;

            // Find the maximum element in the mid column
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            // Check if the found maximum is a peak
            boolean isPeak = true;
            if (midCol > 0 && mat[maxRow][midCol] < mat[maxRow][midCol - 1]) {
                isPeak = false; // Left neighbor
            }
            if (midCol < n - 1 && mat[maxRow][midCol] < mat[maxRow][midCol + 1]) {
                isPeak = false; // Right neighbor
            }

            if (isPeak) {
                return new int[]{maxRow, midCol}; // Return the coordinates of the peak
            } else if (midCol > 0 && mat[maxRow][midCol] < mat[maxRow][midCol - 1]) {
                right = midCol - 1; // Move left
            } else {
                left = midCol + 1; // Move right
            }
        }

        return new int[] {-1,-1}; // In case no peak is found (should not happen)
    }
}