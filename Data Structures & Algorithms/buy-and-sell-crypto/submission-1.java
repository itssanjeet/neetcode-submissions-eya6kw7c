class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MAX_VALUE;

        int max = 0;
        for(int sell: prices){
            if(buy >= sell){
                buy = sell;
            } else {
                max = Math.max(max, sell - buy);
            }
        }

        return max;
    }
}
