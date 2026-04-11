class Twitter {
    int time;
    Map<Integer, List<int[]>> tweeterMap;
    Map<Integer, Set<Integer>> followerMap;
    

    public Twitter() {
        time = 0;
        tweeterMap = new HashMap<>();
        followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweeterMap.putIfAbsent(userId, new ArrayList<>());
        tweeterMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> userIdList = followerMap.getOrDefault(userId, new HashSet<>());
        userIdList.add(userId);

        List<int[]> tweetIdList = new ArrayList<>();
        for(int uId:userIdList){
            List<int[]> tweetIds = tweeterMap.getOrDefault(uId, new ArrayList<>());
            tweetIdList.addAll(tweetIds);
        }

        tweetIdList.sort((a,b) -> b[0]-a[0]);
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<Math.min(10, tweetIdList.size()); i++){
            res.add(tweetIdList.get(i)[1]);
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
