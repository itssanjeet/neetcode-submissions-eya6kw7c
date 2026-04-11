class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        for(int i=0; i<n; i++){
            int start = nums[i];
            int res = 1;
            for(int j=i+1; j<n; j++){
                if(nums[j] == start+1){
                    start++;
                    res++;
                    max = Math.max(max, res);
                }
            }
        }

        return max;
    }
}
