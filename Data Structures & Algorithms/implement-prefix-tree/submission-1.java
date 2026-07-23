class PrefixTree {
    TrieNode root;
    class TrieNode{
        Map<Character, TrieNode> links;
        boolean wordEnd = false;
        public TrieNode(){
            links = new HashMap<>();
        }
    }
    public PrefixTree() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            curr.links.putIfAbsent(word.charAt(i), new TrieNode());
            curr = curr.links.get(word.charAt(i));
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            curr = curr.links.get(word.charAt(i));
            if(curr==null) return false;
        }
        return curr.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            curr = curr.links.get(prefix.charAt(i));
            if(curr==null) return false;
        }
        return true;
    }
}
