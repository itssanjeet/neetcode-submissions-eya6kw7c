class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<n; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                for(int k=j+1; k<n; k++){
                    if(k > j+1 && nums[k] == nums[k-1]){
                        continue;
                    }
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }
}
