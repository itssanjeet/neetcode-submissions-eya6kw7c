class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();

        int n = nums.length;
        if(n < 4){
            return new ArrayList<>(res);
        }

        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int m=k+1; m<n; m++){
                        if(nums[i]+nums[j] + 0L + nums[k] + nums[m] == target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}