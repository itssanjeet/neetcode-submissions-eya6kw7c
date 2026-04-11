class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }

        int idx = 0;
        int sum = 0;
        
        for(int i=0; i<gas.length; i++){
            sum += gas[i] - cost[i];

            if(sum < 0){
                sum = 0;
                idx = i+1;
            }
        }

        return idx;
    }
}
