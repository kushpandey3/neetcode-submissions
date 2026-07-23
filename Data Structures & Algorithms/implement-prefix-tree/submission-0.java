class PrefixTree {
    TrieNode root;
    class TrieNode{
        Character letter;
        Map<Character, TrieNode> links;
        public TrieNode(){
            letter = null;
            links = new HashMap<>();
        }
        public TrieNode(Character let){
            this.letter = let;
            links = new HashMap<>();
        }
    }
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            Character currChar = word.charAt(i);
            if(curr.links.containsKey(currChar)) curr = curr.links.get(currChar);
            else{
                TrieNode ins = new TrieNode(currChar);
                curr.links.put(currChar, ins);
                curr = ins;
            }
        }
        curr.links.put('.', null);
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            curr = curr.links.get(new Character(word.charAt(i)));
            if(curr==null) return false;
        }
        if(curr.links.containsKey('.')) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            curr = curr.links.get(new Character(prefix.charAt(i)));
            if(curr==null) return false;
        }
        return true;
    }
}
