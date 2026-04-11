class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        Arrays.sort(nums);
        Map<Integer, Integer> valueMap = new HashMap<>();
        for(int x:nums){
            if(!valueMap.containsKey(x))
                valueMap.put(x, valueMap.getOrDefault(x-1, 0) + 1);
        }

        int max = 0;
        for(int x:nums){
            max = Math.max(max, valueMap.get(x));
        }
        return max;
    }
}
