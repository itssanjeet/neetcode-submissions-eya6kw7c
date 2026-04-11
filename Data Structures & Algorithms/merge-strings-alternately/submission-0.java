class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0, j=0;

        int l1 = word1.length();
        int l2 = word2.length();

        StringBuilder sb = new StringBuilder();

        while(i < l1 && j < l2){
            if(i <= j){
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
        }

        if(i < l1){
            sb.append(word1.substring(i));
        }

        if(j < l2){
            sb.append(word2.substring(j));
        }

        return sb.toString();
    }
}