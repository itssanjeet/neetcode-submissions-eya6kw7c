class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int n = queries.length;
        int[] res = new int[n];
        int i = 0;

        for(int q:queries){
            int length = Integer.MAX_VALUE;
            for(int[] interval:intervals){
                if(interval[0] <= q && interval[1] >= q){
                    length = Math.min(interval[1] - interval[0] + 1, length);
                }
            }
            if(length == Integer.MAX_VALUE)
                length = -1;
            res[i++] = length;
        }

        return res;
    }
}
