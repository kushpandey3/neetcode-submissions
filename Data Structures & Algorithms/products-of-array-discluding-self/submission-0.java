class Solution {
    public int[] productExceptSelf(int[] nums) {
      int[] ret = new int[nums.length];
      int zeroIndex = -1;
      int totProd = 1;
      for(int i = 0; i < nums.length; i++){
        if(nums[i]==0){
            if(zeroIndex==-1) zeroIndex = i;
            else zeroIndex = nums.length;
        }
        else totProd*=nums[i];
      }
      for(int i = 0; i < nums.length; i++){
        if(zeroIndex==nums.length) ret[i] = 0;
        else if(zeroIndex==-1) ret[i] = totProd/nums[i];
        else{
            if(zeroIndex==i) ret[i] = totProd;
            else ret[i] = 0;
        }

      }
      return ret;
    }
}  
