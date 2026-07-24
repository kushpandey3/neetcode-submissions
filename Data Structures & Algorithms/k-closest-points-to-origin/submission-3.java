class Solution {
    int size = 0;
    public int[][] kClosest(int[][] points, int k) {
        int[][] ret = new int[k][2];
        for(int[] point : points) heapify(ret, point);
        return ret;
    }
    public void heapify(int[][] maxHeap, int[] point){
        if(size<maxHeap.length){
            maxHeap[size] = point;
            bubbleUp(maxHeap, size);
            size++;
        }
        else{
            if(getDist(point)<getDist(maxHeap[0])){
                maxHeap[0] = point;
                bubbleDown(maxHeap, 0);
            }
        }
    }
    public void bubbleUp(int[][] heap, int index){
        while(index>0){
            int parent = (index-1)/2;
            if(getDist(heap[parent])>=getDist(heap[index])) break;
            int[] temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
        }
    }
    public void bubbleDown(int[][] heap, int index){
        while(true){
            int left = index*2 + 1;
            int right = index*2 + 2;
            int biggest = index;
            if(left<size&&getDist(heap[left])>getDist(heap[biggest])){
                biggest = left;
            }
            if(right<size&&getDist(heap[right])>getDist(heap[biggest])){
                biggest = right;
            }
            if(biggest==index) break;
            int[] temp = heap[biggest];
            heap[biggest] = heap[index];
            heap[index] = temp;
            index = biggest;
        }

    }
    public int getDist(int[] point){ //returns square of distance from origin
        return point[0]*point[0] + point[1]*point[1];
    }
}
