class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;

        for(int i=0; i<n; i++){
            int g = gas[i] - cost[i];
            if(g >= 0){
                for(int j = (i+1)%n; j<n; j = (j+1)%n){
                    g += gas[j] - cost[j];
                    if(g < 0){
                        break;
                    }
                    
                    if(j == i){
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}
