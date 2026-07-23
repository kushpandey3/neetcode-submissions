class WordDictionary {
    TrieNode root;
    class TrieNode{
        Map<Character, TrieNode> links;
        boolean wordEnd = false;
        public TrieNode(){
            links = new HashMap<>();
        }
    }
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            curr.links.putIfAbsent(word.charAt(i), new TrieNode());
            curr = curr.links.get(word.charAt(i));
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }
    public boolean search(String word, TrieNode node){
        TrieNode curr = node;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i)=='.'){
                for(TrieNode n : curr.links.values()){
                    if(search(word.substring(i+1), n)) return true;
                }
                return false;
            }
            else{
                curr = curr.links.get(word.charAt(i));
                if(curr==null) return false;
            }
        }
        return curr.wordEnd;
    }
}
