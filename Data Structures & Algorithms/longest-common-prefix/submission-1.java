class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String res = "";
        int minLen = strs[0].length();
        for(String s:strs){
            minLen = Math.min(minLen, s.length());
        }
        
        boolean b = true;
        int idx = 0;
        while(b && idx < minLen){
            char c = strs[0].charAt(idx);
            for(String s:strs){
                if(c != s.charAt(idx)){
                    b = false;
                }
            }


            if(b){
                res += c;
            } 
            idx++;
        }
        

        return res;
    }
}