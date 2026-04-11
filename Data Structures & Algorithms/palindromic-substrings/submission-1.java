class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;//s.length();

        for(int i=0; i<n; i++){
            int l=i, r = i;
            while(l>= 0 && r < n && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }

            //even
            l=i; r = i+1;
            while(l>= 0 && r < n && s.charAt(l) == s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }

        return res;
    }

    private boolean isPalin(String str, int s, int e){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
}
