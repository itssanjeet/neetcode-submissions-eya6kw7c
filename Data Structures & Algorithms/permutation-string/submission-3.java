class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2){
            return false;
        }

        int[] count = new int[26];
        for(int i=0; i<l1; i++){
            count[s1.charAt(i)-'a']++;
        }

        int l=0, r=l1-1;
        for(int i=0; i<r; i++){
            count[s2.charAt(i)-'a']--;
        }

        while(r < l2){
            count[s2.charAt(r)-'a']--;
            r++;
            boolean b = true;
            for(char c:s1.toCharArray()){
                if(count[c-'a'] != 0){
                    b = false;
                }
            }
            count[s2.charAt(l)-'a']++;

            l++;
            if(b){
                return true;
            }
        }

        return false;
    }
}
