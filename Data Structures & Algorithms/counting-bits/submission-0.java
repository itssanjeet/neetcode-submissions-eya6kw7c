class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i=1; i<=n; i++){
            res[i] = getBitCount(i);
        }

        return res;
    }

    private int getBitCount(int val){
        int res = 0;
        while(val > 0){
            res += val%2 == 0? 0:1;
            val = val / 2;
        }

        return res;
    }
}
