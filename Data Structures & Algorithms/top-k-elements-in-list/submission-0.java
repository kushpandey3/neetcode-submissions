class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      LinkedList<Integer>[] freqs = new LinkedList[nums.length+1];
      int[] ret = new int[k];
      for(int i = 0; i < nums.length; i++){
        int currFreq = map.getOrDefault(nums[i],0)+1;
        map.put(nums[i], currFreq);
      }
      for(Integer key : map.keySet()){
        LinkedList<Integer> list = freqs[map.get(key)];
        if(list==null){
          list = new LinkedList<Integer>();
          freqs[map.get(key)] = list;
        }
        list.add(key);
      }
      int soFar = 0;
      int index = freqs.length-1;
      while(index>=0 && soFar < k){
        while(freqs[index]!=null && !freqs[index].isEmpty()){
          ret[soFar] = freqs[index].removeFirst();
          soFar++; 
        }
        index--;
      }
      return ret;
    }
}
