
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (int) Math.sqrt(b[0] * b[0] + b[1] * b[1]) - (int) Math.sqrt(a[0] * a[0] + a[1] * a[1]));
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  (int) Math.sqrt(a[0] * a[0] + a[1] * a[1]) - (int) Math.sqrt(b[0] * b[0] + b[1] * b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],a[0] * a[0] + a[1] * a[1])
        );
        for(int[] p:points){
            pq.add(p);
            for(int[] x:pq){
                System.out.println(Arrays.toString(x));
            }
            System.out.println("");
            if(pq.size() > k){
                pq.poll();
            }
        }

        for(int[] x:pq){
            System.out.println(Arrays.toString(x));
        }

        int[][] res = new int[k][];
        for(int i =0; i<k && !pq.isEmpty(); i++){
            res[i] = pq.poll();
        }

        return res;
    }
}
