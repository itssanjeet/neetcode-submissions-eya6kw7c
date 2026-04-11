class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        dfs(s, 0, new ArrayList<>());

        return res;
    }

    private void dfs(String s, int i, List<String> list){
        if(i == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int j = i; j<s.length(); j++){
            if(isPali(s, i, j)){
                list.add(s.substring(i, j+1));
                dfs(s, j+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPali(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }

        return true;
    }
}
