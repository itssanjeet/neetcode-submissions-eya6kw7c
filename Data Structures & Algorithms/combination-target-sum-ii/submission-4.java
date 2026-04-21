class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }

        Arrays.sort(candidates);

        solve(candidates, 0, target, new ArrayList<>());

        return res;
    }

    private void solve(int[] nums, int i, int target, List<Integer> subList){
        if(target == 0){
            res.add(new ArrayList<>(subList));
            return;
        }

        for(int j=i; j<nums.length; j++){
            if(j>i && nums[j] == nums[j-1]){
                continue;
            }

            if(nums[j] <= target){
                subList.add(nums[j]);
                solve(nums, j+1, target-nums[j], subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}
