class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);

        return nums;
    }

    private void divide(int[] nums, int l, int r){
        
        if(l < r){
            int m = l + (r-l)/2;

            divide(nums, l, m);
            divide(nums, m+1, r);
            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r){
        int l1 = m-l+1;
        int l2 = r - m;

        int left[] = new int[l1];
        int right[] = new int[l2];
        for(int i=0; i<l1; i++){
            left[i] = nums[i+l];
        }

        for(int i=0; i<l2; i++){
            right[i] = nums[i+m+1];
        }

        int i=0, j=0, k=l;

        while(i < l1 && j < l2){
            if(left[i] < right[j]){
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while(i < l1){
            nums[k++] = left[i++];
        }

        while(i < l1){
            nums[k++] = left[j++];
        }
    }
}