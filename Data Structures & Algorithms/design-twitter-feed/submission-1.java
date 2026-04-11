class Twitter {
    int time;
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> followerMap;

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> userList = followerMap.getOrDefault(userId, new HashSet<>());
        userList.add(userId);
        // System.out.println(userList);
        List<int[]> tweetIds = new ArrayList<>();
        for(int id:userList){
            if(tweetMap.containsKey(id)){
                for(int[] t:tweetMap.get(id)){
                    tweetIds.add(t);
                }
            }
        }

        tweetIds.sort((a,b) -> Integer.compare(b[0],a[0]));
        List<Integer> res = new ArrayList<>();
        // for(int[] tweetIdArr:tweetIds){
        //     res.add(tweetIdArr[1]);
        // }
        for(int i=0; i<Math.min(10, tweetIds.size()); i++){
            int[] tweetIdArr = tweetIds.get(i);
            res.add(tweetIdArr[1]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).remove(followeeId);
    }
}
