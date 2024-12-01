class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);
        
        // Check if the target is not present
        if (lb == n || nums[lb] != target) {
            return new int[]{-1, -1}; // Corrected return statement
        } else {
            return new int[]{lb, upperBound(nums, n, target) - 1}; // Corrected return statement
        }
    }

    public static int lowerBound(int[] nums, int n, int target) { // Corrected parameter type
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] nums, int n, int target) { // Corrected parameter type
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [3, 4]
    }
}