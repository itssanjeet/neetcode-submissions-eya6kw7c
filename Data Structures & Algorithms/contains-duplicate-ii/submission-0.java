class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> pair = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(pair.containsKey(nums[i]) && i - pair.get(nums[i]) <= k){
                return true;
            }

            pair.put(nums[i], i);
        }

        return false;
    }
}