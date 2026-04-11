class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1){
            return s;
        }

        String res = "";
        for(int i=0; i<n; i++){
            String currmax = s.substring(i, i+1);
            for(int j=i; j<n; j++){
                if(palindrom(s, i, j) && j-i+1 > currmax.length()){
                    currmax = s.substring(i,j+1);
                }
            }
            
            if(res.length() < currmax.length()){
                res = currmax;
            }
        }

        return res;
    }

    private boolean palindrom(String str, int s, int e){
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
