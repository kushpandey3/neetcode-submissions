class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        for(int i : stones) maxHeap.add(i);
        while(maxHeap.size()>1){
            int ans = maxHeap.poll() - maxHeap.poll();
            if(ans!=0) maxHeap.add(Math.abs(ans));
        }
        if(maxHeap.isEmpty()) return 0;
        return maxHeap.poll();
    }
}
