class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length; // Get the length of the array
        
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            int count = 0; // Initialize count for the current element
            
            // Count occurrences of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++; // Increment count if we find a match
                }
            }
            
            // Check if the count is greater than n/2
            if (count > n / 2) {
                return nums[i]; // Return the majority element
            }
        }
        
        // Since the problem guarantees that a majority element exists,
        // we should never reach here.
        return -1; // Placeholder return (not expected to be reached)
    }
}