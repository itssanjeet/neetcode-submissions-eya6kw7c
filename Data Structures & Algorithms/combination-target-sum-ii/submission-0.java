class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        // int[] arr = Arrays.stream(candidates).distinct().sorted().toArray();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        dfs(candidates, 0, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, int sum, int target, List<Integer> subset, 
        List<List<Integer>> res){
            if(sum == target){
                res.add(new ArrayList<>(subset));
                return;
            }

            for(int j=i; j<nums.length; j++){
                if (j > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                if(sum + nums[j] <= target){
                    subset.add(nums[j]);
                    dfs(nums, j+1, sum+nums[j], target, subset, res);
                    subset.remove(subset.size()-1);
                }
            }
        }
}
