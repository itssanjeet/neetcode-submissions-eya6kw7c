class Solution {

    Map<String, Integer> memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new HashMap<>();

        return solve(nums, 0, Integer.MIN_VALUE);
    }

    private int solve(int[] nums, int i, int pre){
        String key = pre + "*" + i;
        if(i == nums.length){
            return 0;
        }

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int res = solve(nums, i+1, pre);
        if(pre < nums[i]){
            res = Math.max(res, 1 + solve(nums, i+1, nums[i]));
        }

        memo.put(key, res);
        return res;
    }
}
