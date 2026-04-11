class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> new_list = new ArrayList<>();
            for(List<Integer> p:res){
                for(int i=0; i<=p.size(); i++){
                    List<Integer> copy = new ArrayList<>(p);
                    copy.add(i, num);
                    new_list.add(copy);
                }
            }

            res = new_list;
        }

        return res;
    }
}
