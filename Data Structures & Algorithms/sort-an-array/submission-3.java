class Solution {
    public int[] sortArray(int[] nums) {
        // Selection sort 

        int n = nums.length;

        for(int i=0; i<n; i++){

            int min_idx = i;
            for(int j=i+1; j<n; j++){
                if(nums[min_idx] > nums[j]){
                    min_idx = j;
                }
            }

            swap(nums, min_idx, i);
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}