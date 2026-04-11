class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> 
        //     Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0]+a[1]*a[1]));

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> 
            b[0]*b[0] + b[1]*b[1] > a[0]*a[0] + a[1]*a[1]?1:-1);

        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;
        while(!maxHeap.isEmpty()){
            res[idx++] = maxHeap.poll();
        }

        return res;
    }
}
