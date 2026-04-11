class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, 
        List<List<Integer>> res){
        
        res.add(new ArrayList<>(subset));
        for(int j=i; j<nums.length; j++){
            if(j>i && nums[j] == nums[j-1]){
                continue;
            }

            subset.add(nums[j]);
            dfs(nums, j+1, subset, res);
            subset.remove(subset.size()-1);
        }
    }
}
