class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();

        if(l1 > l2){
            return false;
        }

        String str1 = sort(s1);
        for(int i=l1; i<=l2; i++){
            String str2 = sort(s2.substring(i-l1, i));
            if(str1.equals(str2)){
                return true;
            }
        }

        return false;
    }

    private String sort(String s){
        int l = s.length();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        return new String(ch);
    }
}
