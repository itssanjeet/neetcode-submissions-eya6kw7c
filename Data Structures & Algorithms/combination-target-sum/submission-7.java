class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();

        if(nums.length == 0){
            return res;
        }

        Arrays.sort(nums);
        solve(nums, 0, target, new ArrayList<>());
        return res;
    }

    private void solve(int[] nums, int i,int target, List<Integer> subList){
        if(target == 0){
            res.add(new ArrayList<>(subList));
            return;
        }

        for(int j=i; j<nums.length; j++){
            if(nums[j] <= target){
                subList.add(nums[j]);
                solve(nums, j, target-nums[j], subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}
