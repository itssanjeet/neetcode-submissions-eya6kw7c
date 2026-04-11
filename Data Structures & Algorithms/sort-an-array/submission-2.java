class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }

        return nums;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}