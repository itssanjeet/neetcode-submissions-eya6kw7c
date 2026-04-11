class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int min = 1;
        int max = 0;
        for(int p:piles){
            max = Math.max(max, p);
        }

        int l = 1, r = max;
        while(l < r){
            int m = l + (r-l)/2;
            long time = 0;
            for(int p:piles){
                time += (int)Math.ceil((double) p / m);
            }

            if(time > h){
                l = m + 1;
            } else {
                r = m;
            }
        }

        return r;
    }
}
