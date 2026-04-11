class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    int dfs(String w1, String w2, int i, int j){
        int l1 = w1.length();
        int l2 = w2.length();
        if(i == l1) return l2 - j;
        if(j == l2) return l1 - i;

        if(w1.charAt(i) == w2.charAt(j)){
            return dfs(w1, w2, i+1, j+1);
        }

        return 1 + Math.min(dfs(w1, w2, i+1, j), Math.min(dfs(w1, w2, i, j+1), dfs(w1, w2, i+1, j+1)));
    }
}
