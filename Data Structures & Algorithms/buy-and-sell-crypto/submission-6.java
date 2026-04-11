class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0;
        int max = 0;
        for(int r=1; r<prices.length; r++){
            if(prices[l] < prices[r]){
                max = Math.max(max, prices[r]-prices[l]);
            } else {
                l = r;
            }
        }

        return max;
    }
}
