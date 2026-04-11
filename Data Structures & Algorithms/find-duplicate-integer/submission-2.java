class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int idx = (nums[i] % n) - 1;
            nums[idx] += n;
        }

        System.out.println(Arrays.toString(nums));
        for(int i=0; i<n; i++){
            if(nums[i] / n > 1){
                return i+1;
            }
        }

        return 0;
    }
}
