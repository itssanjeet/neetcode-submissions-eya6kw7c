class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            if(num >= 0){
                set.add(num);
            }
        }

        int i=1;
        for(; i<=set.size(); i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return i;
    }
}