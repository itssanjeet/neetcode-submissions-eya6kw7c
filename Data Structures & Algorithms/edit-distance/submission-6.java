class Solution {
    public int minDistance(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }

    private int solve(String w1, String w2, int i, int j){
        if(i == w1.length()){
            return w2.length() - j;
        }

        if(j == w2.length()){
            return w1.length() - i;
        }

        if(w1.charAt(i) == w2.charAt(j)){
            return solve(w1, w2, i+1, j+1);
        }

        int t = solve(w1, w2, i+1, j); // delete
        t = Math.min(t, solve(w1, w2, i, j+1)); // insert
        t = Math.min(t, solve(w1, w2, i+1, j+1)); // replace
        
        return t + 1;
    }
}
