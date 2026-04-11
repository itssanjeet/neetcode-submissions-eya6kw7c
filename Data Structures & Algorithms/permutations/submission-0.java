class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index){
        if(index == nums.length){
            List<Integer> r1 = new ArrayList<>();
            for(int n:nums)
                r1.add(n);
            res.add(r1);
            return;
        }

        for(int i=index; i < nums.length; i++){
            swap(nums, i, index);
            dfs(nums, index+1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
