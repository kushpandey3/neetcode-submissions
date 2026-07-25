class Solution {
    class Node{
        int frequency;
        char task;
        public Node(char task, int frequency){
            this.task = task;
            this.frequency = frequency;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreqs = new int[26];
        for(char i : tasks) taskFreqs[i-'A']++;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        for(int i = 0; i < taskFreqs.length; i++) if(taskFreqs[i]>0) maxHeap.add(new Node((char)('A' + i), taskFreqs[i]));
        Queue<Node> waitingList = new ArrayDeque<>();
        Queue<Integer> entryTimes = new ArrayDeque<>(); //parallel queue
        int time = 0;
        while(!maxHeap.isEmpty() || !waitingList.isEmpty()){
            Node curr = maxHeap.poll();
            if(curr!=null && curr.frequency>1){
                curr.frequency--;
                waitingList.add(curr);
                entryTimes.add(time);
            }
            if(!waitingList.isEmpty()&& time - entryTimes.peek() == n){
                entryTimes.poll();
                maxHeap.add(waitingList.poll());
            }
            time++;
        }
        return time;
    }
}
