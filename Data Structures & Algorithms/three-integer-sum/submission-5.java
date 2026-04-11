class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0){
            return res;
        }

        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1, r = n-1;
            while(l < r){
                if(l > i+1 && nums[l] == nums[l-1]){
                    l++;
                    continue;
                } else if(r < n-1 && nums[r] == nums[r+1]){
                    r--;
                    continue;
                }

                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                } else if(sum < 0){
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}
