class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<int[]> pairs = new ArrayList<>();
        for(int i=0; i<n; i++){
            int[] pair = {position[i], speed[i]};
            pairs.add(pair);
        }

        pairs.sort((a,b) -> b[0] - a[0]);
        Stack<Double> st = new Stack<>();
        for(int[] pair:pairs){
            int p = pair[0];
            int s = pair[1];
            
            double time = (double)(target - p) / (double)s;
            if(st.isEmpty() || st.peek() < time){
                st.push(time);
            }
        }

        return st.size();
    }
}
