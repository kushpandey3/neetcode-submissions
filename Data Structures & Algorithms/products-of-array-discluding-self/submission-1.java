class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i==0) pref[i] = nums[i];
            else pref[i] = pref[i-1]*nums[i];
        }
         for(int i = nums.length-1; i>=0; i--){
            if(i==nums.length-1) suff[i] = nums[i];
            else suff[i] = suff[i+1]*nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            int p = 1;
            int s = 1;
            if(i-1>=0) p = pref[i-1];
            if(i+1<nums.length) s = suff[i+1];
            ret[i] = p * s;
        }
        return ret;
    }
}  
