class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        for(int a:arr){
            list.add(a);
        }

        list.sort((a,b) -> {
            int diff = Math.abs(a-x) - Math.abs(b-x);
            return diff == 0? a-b:diff;
        });

        List<Integer> res = list.subList(0, k);
        Collections.sort(res);

        return res;
    }
}