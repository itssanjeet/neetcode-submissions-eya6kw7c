class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if(n == 0){
            return 0;
        }
        int max = piles[0];
        for(int x:piles){
            max = Math.max(max, x);
        }

        int res = Integer.MAX_VALUE;
        int l = 1, r = max;
        while(l <= r){
            int mid = l + (r-l)/2;
            int hours = 0;
            for(int x:piles){
                int val = (int) Math.ceil((double)x/mid);
                hours += val;
            }

            if(hours <= h){
                res = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
