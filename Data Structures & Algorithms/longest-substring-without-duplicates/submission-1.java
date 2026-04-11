class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int l = 0, r = 1;

        int max = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        while(r < n){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
                continue;
            }
            set.add(s.charAt(r));
            r++;
            max = Math.max(max, r-l);
        }

        return max;
    }
}
