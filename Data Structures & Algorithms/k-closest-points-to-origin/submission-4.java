class Solution {
    int size = 0;
    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;
        int pivot = points.length;
        while(pivot!=k){
            pivot = partition(points, left, right);
            if(pivot<k){
                left = pivot + 1;
            }
            else right = pivot -1;
        }
        int[][] ret = new int[k][2];
        for(int i = 0; i < k; i++){
            ret[i] = points[i];
        }
        return ret;
    }
    public int partition(int[][] points, int left, int right){
        int pivot = right;
        int dist = getDist(points[pivot]);
        int i = left;
        for(int o = left; o < right; o++){
            if(getDist(points[o])<=dist){
                int[] temp = points[i];
                points[i] = points[o];
                points[o] = temp;
                i++;
            }
        }
        int[] temp = points[i];
        points[i] = points[right];
        points[right] = temp;
        return i;
    }
    public int getDist(int[] point){ //returns square of distance from origin
        return point[0]*point[0] + point[1]*point[1];
    }
}
