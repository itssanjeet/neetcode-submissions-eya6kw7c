class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int one = 0, two = 1;

        for(int i=n-1; i>= 0; i--){
            int three = 0;
            if(s.charAt(i) == '0'){
                three = 0;
            } else {
                three = two;
                if(i+1 < n && ( s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
                    three += one;
                }
            }

            one = two;
            two = three;
        }

        return two;
    }
}
