class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1){
            return false;
        }

        int target = sum/2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int x:nums){
            Set<Integer> nextdp = new HashSet<>(dp);
            for(int d:dp){
                if(d+x == target){
                    return true;
                }

                nextdp.add(d+x);
            }
            dp = nextdp;
        }

        return false;
    }
}
