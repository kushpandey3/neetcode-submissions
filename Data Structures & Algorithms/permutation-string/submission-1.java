class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //To avoid out of bounds errors
        if(s2.length()==0) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        //Initiate map1 as the frequency arr for s1
        for(int i = 0; i < s1.length(); i++) map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0) + 1);
        int left = 0, right = 0;
        while(right<s2.length()){
            map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right),0) + 1);
            if(map2.getOrDefault(s2.charAt(right),0) > map1.getOrDefault(s2.charAt(right),0)){
                map2.put(s2.charAt(left), map2.getOrDefault(s2.charAt(left), 1) - 1);
                map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 1) - 1);
                left++; 
            }
            else{
                if(right-left+1==s1.length()) return true;
                right++;
            }
        }
        return false;
    }
}
