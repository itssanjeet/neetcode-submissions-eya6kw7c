class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2){
            return false;
        }

        int[] count = new int[26];
        for(char c:s1.toCharArray()){
            count[c-'a']++;
        }

        int l = 0;

        for(int r=0; r<l2; r++){
            count[s2.charAt(r)-'a']--;
            if(r < l1-1){
                continue;
            }

            boolean b = true;
            for(char c:s1.toCharArray()){
                if(count[c-'a'] != 0){
                    b = false;
                }
            }

            if(b){
                return true;
            }

            count[s2.charAt(l)-'a']++;
            l++;
        }

        return false;
    }
}
