class Twitter {
    HashMap<Integer, Node> posts; //Integer: User ID, Node: Head of tweets sorted by recency
    HashMap<Integer, Set<Integer>> followees; //Integer: User ID, List: Set containing user ids of the followees of that user
    class Tweet{
        static int num = 0;
        int tweetId, time, userID;
        public Tweet(int tweetId, int userId){
            this.tweetId = tweetId;
            this.userID = userId;
            this.time = num;
            num++;
        }
    }
    class Node{
        Tweet content;
        Node next;
        public Node(Tweet cont, Node n){
            content = cont;
            next = n;
        }
    }
    public Twitter() {
        posts = new HashMap<>();
        followees = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet nt = new Tweet(tweetId, userId);
        Node head = new Node(nt, posts.get(userId));
        posts.put(userId, head);
        followees.putIfAbsent(userId, new HashSet<Integer>());
        followees.get(userId).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> b.content.time - a.content.time);
        List<Integer> ret = new ArrayList<>(10);
        Set<Integer> followed = followees.get(userId);
        if(followed==null) return ret;
        for(Integer followedId : followed){
            Node h = posts.get(followedId);
            if(h!=null) heap.add(h);
        }
        int i = 0;
        while(i<10 && !heap.isEmpty()){
            Node p = heap.poll();
            ret.add(p.content.tweetId);
            if(p.next!=null) heap.add(p.next);
            i++;
        }
        return ret;
    }
    
    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<Integer>());
        followees.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followees.containsKey(followerId) && followerId!=followeeId)
        followees.get(followerId).remove(followeeId);
    }
}
