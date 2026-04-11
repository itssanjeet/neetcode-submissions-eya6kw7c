class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0, r = 1;

        int max = 0;
        while(r < n){
            if(prices[l] < prices[r]){
                max = Math.max(prices[r] - prices[l], max);
            } else {
                l = r;
            }
            r++;
        }

        return max;
    }
}
