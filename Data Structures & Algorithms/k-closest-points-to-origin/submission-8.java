class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
            b[1]*b[1] + b[0]*b[0] > a[1]*a[1] + a[0]*a[0]? 1:-1);

        for(int[] point:points){
            pq.add(point);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()){
            res[idx++] = pq.poll();
        }

        return res;
    }
}
