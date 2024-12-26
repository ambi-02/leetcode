class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Check if (target + sum) is even and non-negative
        if ((target + sum) % 2 != 0 || target + sum < 0) {
            return 0;
        }

        int P = (target + sum) / 2;
        return countSubsets(nums, P);
    }

    private int countSubsets(int[] nums, int P) {
        int[] dp = new int[P + 1];
        dp[0] = 1; // There's one way to make sum 0: choose nothing

        for (int num : nums) {
            for (int j = P; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[P];
    }
}