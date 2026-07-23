class KthLargest {
    int[] arr;
    int size;
    public KthLargest(int k, int[] nums) {
        arr = new int[k];
        size = 0;
        for(int i : nums) heapify(i);
    }
    
    public int add(int val) {
        heapify(val);
        return arr[0];
    }
    public void heapify(int val){
        if(size<arr.length){
            arr[size] = val;
            bubbleUp(size);
            size++;
        }
        else if(val>arr[0]){
            arr[0] = val;
            bubbleDown(0);
        }
    }
    public void bubbleUp(int index){
        while(index>0){
            int parInd = (index-1)/2;
            if(arr[parInd]<=arr[index]) break;
            int temp = arr[index];
            arr[index] = arr[parInd];
            arr[parInd] = temp;
            index = parInd;
        }
    }
    public void bubbleDown(int index){
        while(true){
            int left = index*2 + 1;
            int right = index*2 + 2;
            int small = index;
            if(left<size && arr[left] < arr[small]) small = left;
            if(right<size && arr[right] < arr[small]) small = right;
            if(small==index) break;
            int temp = arr[small];
            arr[small] = arr[index];
            arr[index] = temp;
            index = small;
        }
    }
}
