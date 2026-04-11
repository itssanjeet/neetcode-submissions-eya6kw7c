class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Set<Integer> set = new HashSet<>();
        int i = 0, k = 0;
        for(int j=0; j<n; j++){
            if(!set.contains(nums[j])){
                res[i++] = nums[j];
            } else {
                k++;
            }

            set.add(nums[j]);
        }

        for(int j=0; j<res.length; j++){
            nums[j] = res[j];
        }

        return n - k;
    }
}