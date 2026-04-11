class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = s.length();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isPalin(s, i, j)){
                    res++;
                }
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
