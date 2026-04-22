class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n == 0 || k > n){
            return res;
        }
        solve(1, n, k, new ArrayList<>());

        return res;
    }

    private void solve(int i, int n,int k, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j<=n; j++){
            list.add(j);
            solve(j+1, n, k,list);
            list.remove(list.size()-1);
        }
    }
}