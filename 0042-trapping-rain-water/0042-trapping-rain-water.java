public class Solution {
    public int trap(int[] height) {
             int left = 1;
        int right = height.length - 2;

        // lMax : Maximum in subarray arr[0..left-1]
        // rMax : Maximum in subarray arr[right+1..n-1]
        int lMax = height[left - 1];
        int rMax = height[right + 1];

        int res = 0;
        while (left <= right) {
          
            // If rMax is smaller, then we can decide the amount of water for arr[right]
            if (rMax <= lMax) {
              
                // Add the water for arr[right]
                res += Math.max(0, rMax -height[right]);

                // Update right max
                rMax = Math.max(rMax, height[right]);

                // Update right pointer as we have decided the amount of water for this
                right -= 1;
            } else { 
              
                // Add the water for arr[left]
                res += Math.max(0, lMax - height[left]);

                // Update left max
                lMax = Math.max(lMax, height[left]);

                // Update left pointer as we have decided water for this
                left += 1;
            }
        }
        return res;
    }
}