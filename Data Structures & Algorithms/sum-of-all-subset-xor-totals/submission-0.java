class Solution {
    public int subsetXORSum(int[] nums) {
        
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int res = 0;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int x:nums){
            int size = list.size();
            for(int i=0; i<size; i++){
                List<Integer> subList = new ArrayList<>(list.get(i));
                subList.add(x);
                list.add(subList);
                int xor = 0;
                for(int y:subList){
                    xor ^= y;
                }

                res += xor;
            }
        }

        return res;
    }
}