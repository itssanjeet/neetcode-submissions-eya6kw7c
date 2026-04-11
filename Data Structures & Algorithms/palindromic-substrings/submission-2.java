class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = n;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(palindrom(s.substring(i, j+1))){
                    res++;
                }
            }
        }

        return res;
    }

    private boolean palindrom(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }

        return true;
    }
}
