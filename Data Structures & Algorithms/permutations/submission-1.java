class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        solve(nums, 0);
        return res;
    }

    private void solve(int[] nums, int idx){
        if(idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int x:nums){
                list.add(x);
            }
            res.add(list);

            return;
        }

        for(int j=idx; j<nums.length; j++){
            swap(nums, idx, j);
            solve(nums, idx+1);
            swap(nums, idx, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
