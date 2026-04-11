class Solution {
    public int jump(int[] nums) {
        
        int res = 0;
        int l=0, r=0;

        while( r < nums.length-1){
            int farthest = 0;

            for(int idx=l; idx<=r; idx++){
                farthest = Math.max(farthest, idx + nums[idx]);
            }

            l = r+1;
            r = farthest;
            res++;
        }

        return res;
    }
}
