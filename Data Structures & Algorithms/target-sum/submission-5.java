class Solution {

    Map<String, Integer> memo;   

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return solve(nums, 0, target, 0);
    }

    private int solve(int[] nums, int idx, int t, int sum){
        if(idx == nums.length){
            return sum == t? 1:0;
        }

        String key = idx + "-" + sum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int res = solve(nums, idx+1, t, sum - nums[idx]) 
                + solve(nums, idx+1, t, sum + nums[idx]);

        memo.put(key, res);

        return res;
    }
}
