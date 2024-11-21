class Solution {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
    //     int pro=1;
    //    for(int i=0;i<nums.length; i++ ){
    //      pro = pro*nums[i];

    //      if(pro>maxi){
    //         maxi= pro;
    //      }
    //      if(pro<0){
    // //         pro=1;
    // //      }
    //    }
        for(int i=0;i<nums.length; i++ ){
           int pro=1;
            for(int j=i; j<nums.length; j++){
                pro = pro*nums[j];
                maxi = Math.max(maxi, pro);
            }
        }
         return maxi;
    }
}