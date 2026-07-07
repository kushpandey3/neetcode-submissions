class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length*matrix[0].length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int num = matrix[mid/matrix[0].length][mid - (mid/matrix[0].length)*matrix[0].length];
            if(num==target) return true;
            if(num<target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
