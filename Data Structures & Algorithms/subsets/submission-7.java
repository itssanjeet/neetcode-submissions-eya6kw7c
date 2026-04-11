class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num:nums){
            int size = res.size();
            for(int i=0; i<size; i++){
                List<Integer> sublist = new ArrayList<>(res.get(i));
                sublist.add(num);
                res.add(sublist);
            }
        }

        return res;
    }
}
