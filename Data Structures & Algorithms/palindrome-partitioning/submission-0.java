class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int i, List<String> substr, List<List<String>> res){
        if(i >= s.length()){
            res.add(new ArrayList<>(substr));
            return;
        }

        for(int j=i; j<s.length(); j++){
            if(isPali(s, i, j)){
                substr.add(s.substring(i, j+1));
                dfs(s, j+1, substr, res);
                substr.remove(substr.size()-1);
            }
        }
    }

    private boolean isPali(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++; j--;
        }

        return true;
    }
}
