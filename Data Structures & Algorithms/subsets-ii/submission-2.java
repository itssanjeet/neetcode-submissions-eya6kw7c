class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return res;
    }

    private void solve(int[] nums, int idx, List<Integer> list){
        if(idx == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        solve(nums, idx+1, list);
        list.remove(list.size()-1);
        
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        solve(nums, idx+1, list);
    }
}
