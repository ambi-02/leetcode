class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Initialize the candidate
        int count = 1; // Initialize the count

        // Step 1: Find a candidate for the majority element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++; // Increment count if the same as candidate
            } else {
                count--; // Decrement count if different
            }

            // If count reaches 0, select the current number as the new candidate
            if (count == 0) {
                candidate = nums[i];
                count = 1; // Reset count for the new candidate
            }
        }

        // Step 2: Validate the candidate
        count = 0; // Reset count for validation
        for (int num : nums) {
            if (num == candidate) {
                count++; // Count occurrences of the candidate
            }
        }

        // Since the problem guarantees that a majority element exists,
        // we can return the candidate directly.
        return candidate;
    }
}