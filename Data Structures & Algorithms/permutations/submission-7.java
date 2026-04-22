class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        solve(nums, 0);

        return res;
    }

    private void solve(int[] nums, int i){
        if(i==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int x:nums){
                list.add(x);
            }
            res.add(list);
            return;
        }

        for(int j=i; j<nums.length; j++){
            swap(nums, i, j);
            solve(nums, i+1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
