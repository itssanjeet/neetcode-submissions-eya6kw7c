class Solution {
    public int climbStairs(int n) {
        int one = 0, two = 1;
        
        for(int i=1; i<= n; i++){
            int three = one + two;
            one = two;
            two = three;
        }

        return two;
    }
}
