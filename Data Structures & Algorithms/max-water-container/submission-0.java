class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int max = 0;
        while(left<right){
            int area = Math.min(heights[left],heights[right]) * (right-left);
            if(area>max) max = area;
            if(heights[left]<heights[right]) left++;
            else if(heights[left]>heights[right]) right--;
            else{
                if(heights[left+1]>heights[right-1]) left++;
                else right--;
            }
        }
        return max;
    }
}
