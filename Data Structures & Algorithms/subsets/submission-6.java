class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> list){
        if(i == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        dfs(nums, i+1, list);
        list.remove(list.size() -1);
        dfs(nums, i+1, list);
    }
}
