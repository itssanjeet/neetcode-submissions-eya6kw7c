class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(maxCount < val){
                maxCount = val;
                res = key;
            }
        }

        return res;
    }
}