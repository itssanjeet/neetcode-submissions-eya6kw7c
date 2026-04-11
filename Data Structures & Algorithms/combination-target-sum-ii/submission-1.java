class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);

        solve(candidates, 0, 0, target, new ArrayList<>());

        return res;
    }

    private void solve(int[] nums, int idx, int sum, int target, List<Integer> list){
        if(target == sum){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            
            if(sum+nums[i] <= target){
               list.add(nums[i]);
               solve(nums, i+1, sum+nums[i], target, list);
               list.remove(list.size()-1); 
            }
        }
    }
}
