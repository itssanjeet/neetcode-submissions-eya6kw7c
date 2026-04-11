class Solution {

    Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int i){
        if(i == nums.length){
            return target == 0? 1:0;
        }
        String key = i + "-" + target;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int res = dfs(nums, target-nums[i], i+1) + dfs(nums, target+nums[i], i+1);
        memo.put(key, res);
        return res;
    }
}
