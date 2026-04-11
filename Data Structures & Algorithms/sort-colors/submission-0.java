class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);

    }

    private void quickSort(int[] nums, int l, int r){
        if(l < r){
            int p = pivot(nums, l, r);

            quickSort(nums, l, p-1);
            quickSort(nums, p+1, r);
        }
    }

    private int pivot(int[] nums, int l, int r){
        int h = nums[r];

        int i = l - 1;

        for(int j=l; j<r; j++){
            if(nums[j] < h){
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i+1, r);

        return i+1;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}