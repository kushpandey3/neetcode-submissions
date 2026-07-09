class TimeMap {
    public Map<String, ArrayList<Pair>> map;
    static class Pair{
        int timestamp;
        String value;
        public Pair(int t, String v){
            timestamp = t;
            value = v;
        }
    }
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) map.get(key).add(new Pair(timestamp, value));
        else{
            ArrayList<Pair> l = new ArrayList<Pair>();
            l.add(new Pair(timestamp, value));
            map.put(key, l);
        }
    }

    public String get(String key, int timestamp) {
        ArrayList<Pair> arr = map.get(key);   
        if(arr==null) return "";
        int left = 0;
        int right = arr.size() - 1;
        int maxTime = Integer.MIN_VALUE;
        String value = "";
        while(left<=right){
            int mid = left + (right-left)/2;
            int tstamp = arr.get(mid).timestamp;
            if(tstamp<=timestamp){
                maxTime = tstamp;
                value = arr.get(mid).value;
                left = mid+1;
            } 
            else {
                right = mid-1;
            }
        }
        return value;
    }
}
