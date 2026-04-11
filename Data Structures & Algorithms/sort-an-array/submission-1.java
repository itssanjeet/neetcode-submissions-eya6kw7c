class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        quickSort(nums, 0, n-1);

        return nums;
    }

    private void quickSort(int[] nums, int l, int h){
        if(l < h){
            int p = pivot(nums, l, h);

            quickSort(nums, l, p-1);
            quickSort(nums, p+1, h);
        }
    }

    private int pivot(int[] nums, int l, int h){
        int p = nums[h];

        int i = l - 1;
        for(int j=l; j<h; j++){
            if(nums[j] < p){
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i+1, h);

        return i+1;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}