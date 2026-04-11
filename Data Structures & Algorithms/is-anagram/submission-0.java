class Solution {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int t1 = t.length();
        if(s1 != t1){
            return false;
        }

        int code[] = new int[26];
        
        for(int i=0; i<s1; i++){
            code[s.charAt(i)-'a']++;
            code[t.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++){
            if(code[i] != 0){
                return false;
            }
        }

        return true;
    }
}
