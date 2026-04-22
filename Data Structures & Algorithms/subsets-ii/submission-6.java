class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }

        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());

        return res;
    }

    private void solve(int[] nums, int i, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int j=i; j<nums.length; j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }

            list.add(nums[j]);
            solve(nums, j+1, list);
            list.remove(list.size()-1);
        }
    }
}
