class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int[] count = new int[26];
        
        int l = 0, maxCount = 0, res = 0;
        for(int r=0; r<n; r++){
            count[s.charAt(r)-'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(r)-'A']);
            
            if((r-l+1) - maxCount > k){
                count[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(res, (r-l+1));
        }

        return res;
    }
}
