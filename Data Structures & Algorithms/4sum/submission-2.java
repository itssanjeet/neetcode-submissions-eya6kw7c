class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        if(n < 4){
            return new ArrayList<>(res);
        }

        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<n; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }


                int l = j+1, r = n-1;
                while(l < r){
                    if(l > j+1 && nums[l] == nums[l-1]){
                        l++;
                        continue;
                    }

                    if(r < n-1 && nums[r] == nums[r+1]){
                        r--;
                        continue;
                    }

                    long sum = nums[i] + nums[j] + 0L + nums[l] + nums[r];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; r--;
                    } else if(sum < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}