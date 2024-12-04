class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        // edge case handling
         if(n==1) return 0;
         if(nums[0]>nums[1]) return 0;
         if(nums[n-1]>nums[n-2]) return n-1;

         int low=1;
         int high=n-2;
         while(low<=high){
            int mid=(low+high)/2;
            // if mid is the peak
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            // peak is at right half
            else if(nums[mid]>nums[mid-1]){
                low=mid+1;
            }
            // peak is at left half OR mid is the low point where (mid<mid+1)&(mid<mid-1)
            else{
            high=mid-1;
            }
         }
         return -1;
    }
}