class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int i=0, j=0;
        while(j < n){
            nums[i] = nums[j];
            while(j < n && nums[i] == nums[j]){
                j++;
            }

            i++;
        }

        return i;
    }
}