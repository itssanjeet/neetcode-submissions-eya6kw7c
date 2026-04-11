class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int x[]:intervals){
            if(end >= x[0]){
                end = Math.max(x[1], end);
            } else {
                list.add(new int[]{start, end});
                start = x[0];
                end = x[1];
            }
        }
        list.add(new int[]{start, end});

        int[][] res = new int[list.size()][];
        int idx = 0;
        for(int[] x:list){
            res[idx++] = x;
        }

        return res;
    }
}
