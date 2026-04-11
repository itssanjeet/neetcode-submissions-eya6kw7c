class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new int[]{position[i], speed[i]});
        }

        Collections.sort(list, (a,b) -> b[0]-a[0]);
        Stack<Double> st = new Stack<>();
        for(int[] pair: list){
            double time = (target-pair[0])/(double)pair[1];
            if(st.isEmpty() || st.peek() < time){
                st.push(time);
            }
        }

        return st.size();
    }
}
