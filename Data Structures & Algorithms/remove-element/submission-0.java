class Solution {
    public int removeElement(int[] nums, int val) {
        
        int res = 0;
        for(int num: nums){
            if(num != val){
                nums[res++] = num;
            }
        }

        return res;
    }
}