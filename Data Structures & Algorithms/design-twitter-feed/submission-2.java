class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets = tweetMap.getOrDefault(userId, new LinkedList<>());
        tweets.addFirst(new int[]{time++, tweetId});
        tweetMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followeeSet = new HashSet(followMap.getOrDefault(userId, new HashSet<>()));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> o1[0]-o2[0]);
        followeeSet.add(userId);
        for(Integer followee : followeeSet){
            List<int[]> tweets = tweetMap.getOrDefault(followee, new ArrayList<>());
            Iterator iter = tweets.iterator();
            int idx = 0;
            while(iter.hasNext() && idx < 10){
                pq.offer((int[])iter.next());
                idx++;
                if(pq.size() > 10){
                    pq.poll();
                }
            }  
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll()[1]);
        }

        Collections.reverse(result);

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeSet = followMap.getOrDefault(followerId, new HashSet<>());
        followeeSet.add(followeeId);
        followMap.put(followerId, followeeSet);  
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeSet = followMap.get(followerId);
        followeeSet.remove(followeeId);   
    }
}
