public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0; // No elevation means no water trapped

        // Create prefix and suffix max arrays
        int[] prefix_max = new int[n];
        int[] suffix_max = new int[n];

        // Fill prefix_max array
        prefix_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefix_max[i] = Math.max(prefix_max[i - 1], height[i]);
        }

        // Fill suffix_max array
        suffix_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix_max[i] = Math.max(suffix_max[i + 1], height[i]);
        }

        // Calculate the total water trapped
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.max(0, Math.min(prefix_max[i], suffix_max[i]) - height[i]);
        }

        return totalWater;
    }
}