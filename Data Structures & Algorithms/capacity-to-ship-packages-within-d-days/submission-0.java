class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        int max = 0;
        for(int w: weights){
            sum += w;
            max = Math.max(max, w);
        }

        for(int i=max; i <= sum; i++){
            
            int count = 0;
            int day = 0;
            for(int w: weights){
                if(count + w > i){
                    count = 0;
                    day++;
                }

                count += w;
            }

            day++;
            if(day <= days){
                return i;
            }
        }

        return sum;
    }
}