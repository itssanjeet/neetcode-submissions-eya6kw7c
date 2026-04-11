class Solution {

    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }

        int zero = 1, one = 1;

        for(int i = 2; i<=n; i++){
            int two = zero + one;
            zero = one;
            one = two;
        }
        
        return one;
    }
}
