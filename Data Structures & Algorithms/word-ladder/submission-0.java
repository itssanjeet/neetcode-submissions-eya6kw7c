class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        wordList.add(beginWord);
        Map<String, List<String>> adjList = new HashMap<>();
        for(String word:wordList){
            for(int j=0; j<word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j+1, word.length());
                adjList.putIfAbsent(pattern, new ArrayList<>());
                adjList.get(pattern).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String word = q.poll();

                if(word.equals(endWord)){
                    return res;
                }
                for(int j=0; j<word.length(); j++){
                    String pattern = word.substring(0, j) + "*" + word.substring(j+1, word.length());
                    for(String neiWord:adjList.get(pattern)){
                        if(!visited.contains(neiWord)){
                            visited.add(neiWord);
                            q.add(neiWord);
                        }
                    }
                }
            }

            res++;
        }

        return 0;
    }
}
