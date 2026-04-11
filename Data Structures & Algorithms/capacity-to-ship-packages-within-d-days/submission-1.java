class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        int max = 0;
        for(int w: weights){
            sum += w;
            max = Math.max(max, w);
        }

        int l = max, r = sum;
        while(l < r){
            int capacity = l + (r-l)/2;

            int sum1 = 0;
            int dayCount = 0;
            for(int w: weights){
                if(sum1 + w > capacity){
                    sum1 = 0;
                    dayCount++;
                }

                sum1 += w;
            }

            dayCount++;
            if(dayCount > days){
                l = capacity + 1;
            } else {
                r = capacity;
            }
        }

        return r;
    }
}