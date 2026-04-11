class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        solve(nums, 0, target, 0, new ArrayList<>());
        
        return res;
    }

    private void solve(int[] nums, int idx, int target, int sum, List<Integer> list){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            if(sum + nums[i] <= target){                
                list.add(nums[i]);
                solve(nums, i, target, (sum + nums[i]), list);
                list.remove(list.size()-1);
            }
        }
    }
}