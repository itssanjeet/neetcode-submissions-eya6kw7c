class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i=0; i<n; i++){
            newNums[i+1] = nums[i];
        }

        return dfs(newNums);
    }

    private int dfs(int[] nums){
        if(nums.length==2){
            return 0;
        }

        int maxCoins = 0;
        for(int i=1; i<nums.length-1; i++){
            int coins = nums[i-1] * nums[i] * nums[i+1];
            int[] newNums = new int[nums.length-1];
            for(int j=0, k=0; j<nums.length; j++){
                if(j != i){
                    newNums[k++] = nums[j];
                }
            }

            coins += dfs(newNums);
            maxCoins = Math.max(maxCoins, coins);
        }

        return maxCoins;
    }
}
