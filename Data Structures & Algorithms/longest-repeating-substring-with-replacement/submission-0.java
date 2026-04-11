class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int res = 0;
        for(int i=0; i<n; i++){
            Map<Character, Integer> hm = new HashMap<>();
            int maxCount = 0;
            for(int j=i; j<n; j++){
                char c = s.charAt(j);
                hm.put(c, hm.getOrDefault(c, 0) + 1);
                maxCount = Math.max(maxCount, hm.get(c));

                if((j-i+1) - maxCount <= k){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        
        return res;
    }
}
