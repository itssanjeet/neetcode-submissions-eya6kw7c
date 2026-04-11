class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2){
            return false;
        }

        char[] ch = s1.toCharArray();
        Arrays.sort(ch);
        String s1Sorted = new String(ch);
        for(int i=0; i<=l2-l1; i++){
            char[] chSub = s2.substring(i, i+l1).toCharArray();
            Arrays.sort(chSub);
            String subSorted = new String(chSub);

            if(s1Sorted.equals(subSorted)){
                return true;
            }
        }

        return false;
    }
}
