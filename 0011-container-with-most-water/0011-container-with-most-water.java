class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int i=0, j=height.length-1;
        while(i<j){
            int w=j-i;
            int h=Math.min(height[i],height[j]);
            int calArea= w*h;
            if(calArea>area)
            area=calArea;
            if(height[i]<height[j])
            i++;
            else 
            j--;

        }
        return area;
    }
}