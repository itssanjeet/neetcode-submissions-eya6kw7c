class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        res = new ArrayList<>();

        dfs(nums, 0, target, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int i, int target, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j<nums.length; j++){
            if(nums[j] <= target){
                list.add(nums[j]);
                dfs(nums, j, target - nums[j], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
