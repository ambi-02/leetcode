class Solution {
    public int maxProduct(int[] nums) {
        // int maxi = Integer.MIN_VALUE;
        // for(int i=0;i<nums.length; i++ ){
        //    int pro=1;
        //     for(int j=i; j<nums.length; j++){
        //         pro = pro*nums[j];
        //         maxi = Math.max(maxi, pro);
        //     }
        // }
        //  return maxi;
              // Edge case: if the array is empty
        if (nums.length == 0) return 0;

        // Initialize variables
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If the current number is negative, swap currentMax and currentMin
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Calculate the maximum and minimum products
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            // Update the overall maximum product
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
    }
