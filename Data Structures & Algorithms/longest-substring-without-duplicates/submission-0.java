class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int l = 0, r = 1;
        int max = 1;
        while(r < n){
            if(s.substring(l, r).contains(String.valueOf(s.charAt(r)))){
                l++;
                continue;
            }
            r++;
            max = Math.max(max, r-l);
        }

        return max;
    }
}
