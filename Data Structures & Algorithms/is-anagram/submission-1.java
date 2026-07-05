class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i = 0; i < t.length(); i++) {
            char d = t.charAt(i);
            int val = map.getOrDefault(d,0) - 1;
            if(val==-1) return false;
            map.put(d,val);
        }
        HashSet<Integer> values = new HashSet<>(map.values());
        values.remove(0);
        return values.isEmpty();
    }
}
