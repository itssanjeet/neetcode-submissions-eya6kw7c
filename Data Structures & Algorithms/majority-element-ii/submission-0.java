class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num:nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        System.out.println(countMap);
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            if((double)entry.getValue() > (double)n/3){
                res.add(entry.getKey());
            }
        }

        return res;
    }
}