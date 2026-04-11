class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, target, 0, res, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums,int i, int target, int sum
        , List<List<Integer>> res, List<Integer> subset){
        if(sum == target){
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int j=i; j<nums.length; j++){
            if(sum + nums[j] > target){
                return;
            }
            subset.add(nums[j]);
            dfs(nums, j, target, sum+nums[j], res, subset);
            subset.remove(subset.size()-1);
        }
    }
}
