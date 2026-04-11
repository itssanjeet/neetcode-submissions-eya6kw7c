class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        wordList.add(endWord);
        Map<String, List<String>> adj = new HashMap<>();
        for(String w: wordList){
            
            for(int j = 0; j<w.length(); j++){
                String pattern = w.substring(0, j) + "*" + w.substring(j+1, w.length());
                adj.putIfAbsent(pattern, new ArrayList<>());
                adj.get(pattern).add(w);
            }
        }

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);

        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                String w = q.poll();

                if(w.equals(endWord)){
                    return res;
                }

                visit.add(w);

                for(int j = 0; j<w.length(); j++){
                    String pattern = w.substring(0, j) + "*" + w.substring(j+1, w.length());
                    for(String nei: adj.getOrDefault(pattern, new ArrayList<>())){
                        if(!visit.contains(nei)){
                            q.add(nei);
                        }
                    }
                }
            }

            res++;
        }
        

        return 0;

    }
}
