class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String str = "";
        int res = 0;
        for(int i=0; i<n; i++){
            //odd number
            int l = i, r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > res){
                    res = r-l+1;
                    str = s.substring(l, r+1);
                }
                l--; r++;
            }

            //even number
            l = i; r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > res){
                    res = r-l+1;
                    str = s.substring(l, r+1);
                }
                l--; r++;
            }
        }

        return str;
    }
}
