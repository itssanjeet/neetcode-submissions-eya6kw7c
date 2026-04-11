class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2){
            return false;
        }

        for(int i = 0; i <=l2-l1; i++){
            int[] count = new int[26];
            for(int j = 0; j<l1; j++){
                count[s1.charAt(j) - 'a']++;
            }

            for(int j = i; j<i+l1; j++){
                count[s2.charAt(j)-'a']--;
            }

            boolean b = true;
            for(int j=0; j<l1; j++){
                if(count[s1.charAt(j)-'a'] != 0){
                    b = false;
                }
            }

            if(b){
                return true;
            }
        }

        return false;
    }
}
