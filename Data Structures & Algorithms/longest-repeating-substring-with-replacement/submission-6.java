class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int[] count = new int[26];
        int maxf = 0;
        int res = 0;
        for(int r=0; r<n; r++){
            count[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, count[s.charAt(r)-'A']);

            while((r-l+1) - maxf > k){
                count[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
