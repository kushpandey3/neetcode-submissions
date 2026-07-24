class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums){
            if(minHeap.size()>k){
                if(i>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(i);
                }
            }
            else minHeap.add(i);
        }
        for(int i = 0; i < minHeap.size()- k; i++) minHeap.poll();
        return minHeap.peek();
    }
}
