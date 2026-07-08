class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = -1;
        int low = 1;
        int high = -1;
        for(int i : piles) if (i>high) high = i;
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean val = isValid(piles, mid, h);
            if(val){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public boolean isValid(int[] piles, int k, int h){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil(1.0*pile/k);
        }
        if(hours>h) return false;
        return true;
    }
}
