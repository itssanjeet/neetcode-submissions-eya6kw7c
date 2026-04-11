class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        // res.add(new ArrayList<>());

        // for(int num: nums){
        //     List<List<Integer>> copy = new ArrayList<>(res);

        //     for(int i=0; i<size; i++){
        //         List<Integer> list = new ArrayList<>(res.get(i));
        //         list.add(i, num);
        //         res.add(list);
        //     }
        // }

        dfs(nums, 0);

        return res;
    }

    private void dfs(int[] nums, int i){
        if(i == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int x:nums){
                list.add(x);
            }
            res.add(list);
            return;
        }

        for(int j=i; j<nums.length; j++){
            swap(nums, i, j);
            dfs(nums, i+1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
