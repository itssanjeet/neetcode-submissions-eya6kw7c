class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();

        Arrays.sort(candidates);
        solve(candidates, 0, 0, target, new ArrayList<>());
        
        return res;
    }

    private void solve(int[] nums, int i, int sum, int target, List<Integer> list){
        if(target == sum){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }

            if(sum + nums[j] <= target){
                list.add(nums[j]);
                solve(nums, j+1, sum + nums[j], target, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
