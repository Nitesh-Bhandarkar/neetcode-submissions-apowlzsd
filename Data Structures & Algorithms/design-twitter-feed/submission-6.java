class Twitter {
    Map<Integer, PriorityQueue<int[]>> userPosts;
    Map<Integer, Set<Integer>> userFollowingMap;
    int time;

    public Twitter() {
        userPosts = new HashMap<>();
        userFollowingMap = new HashMap<>();   
        time = 0; 
    }
    
    public void postTweet(int userId, int tweetId) {
        PriorityQueue<int[]> pq = userPosts.getOrDefault(userId, new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]));
        pq.offer(new int[]{time++, tweetId});
        if(pq.size() > 10){
            pq.poll();
        }
        userPosts.put(userId, pq);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followingList = userFollowingMap.getOrDefault(userId, new HashSet<>());
        PriorityQueue<int[]> list = new PriorityQueue<>(userPosts.getOrDefault(userId, new PriorityQueue<>((o1, o2) -> o1[0] - o2[0])));
        for(int followee : followingList){
            list.addAll(userPosts.getOrDefault(followee, new PriorityQueue<>()));
        }

        while(list.size() > 10){
            list.poll();
        }

        List<Integer> result = new ArrayList<>();
        while(!list.isEmpty()){
            result.add(list.poll()[1]);
        }
        Collections.reverse(result);

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        userFollowingMap.computeIfAbsent(followerId, f -> new HashSet<>()).add(followeeId); 
        System.out.println(userFollowingMap.get(followerId));  
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        Set<Integer> followingList = userFollowingMap.get(followerId);
        followingList.remove(followeeId); 
    }
}
