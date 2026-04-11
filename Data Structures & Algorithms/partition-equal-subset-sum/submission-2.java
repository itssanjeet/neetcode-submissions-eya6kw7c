class Solution {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }

        System.out.println(sum);
        int target = sum/2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int x:nums){
            Set<Integer> nextDp = new HashSet<>();
            for(int d:dp){
                if(d + x == target){
                    return true;
                }
                nextDp.add(d);
                nextDp.add(d + x);
            }

            dp = nextDp;
            System.out.println(dp);
        }

        return false;
    }

    // private boolean dfs(int[] nums, int i, int subsum){
    //     if(sum - subsum == subsum){
    //         return true;
    //     }

    //     if(i == nums.length){
    //         return false;
    //     }

    //     return dfs(nums, i+1, subsum + nums[i]) || dfs(nums, i+1, subsum);
    // }
}
