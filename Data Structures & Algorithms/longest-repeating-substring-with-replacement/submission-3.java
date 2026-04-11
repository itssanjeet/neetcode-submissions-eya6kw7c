class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int res = 0;
        int[] counts = new int[26];
        int l = 0, maxf = 0;
        for(int r = 0; r<n; r++){
            counts[s.charAt(r)-'A']++;
            maxf = Math.max(maxf, counts[s.charAt(r) - 'A']);

            while((r-l+1) - maxf > k){
                counts[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
