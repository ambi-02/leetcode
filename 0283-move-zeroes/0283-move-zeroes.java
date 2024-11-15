class Solution {
    public int[] moveZeroes(int[] nums) {
        int n = nums.length;
         int j = -1;
        //place the pointer j:
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
         //no non-zero elements:
        if (j == -1) return nums;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        return nums;
    }
}