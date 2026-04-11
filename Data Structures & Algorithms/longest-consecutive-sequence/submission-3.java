class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }

        int max = 0;
        for(int x:nums){
            int res = 1;
            x++;
            while(set.contains(x)){
                res++;
                x++;
            }

            max = Math.max(max, res);
        }

        return max;
    }
}
