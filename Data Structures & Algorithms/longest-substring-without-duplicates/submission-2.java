class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Queue<Character> q = new ArrayDeque<>();
        HashSet<Character> set = new HashSet<>();
        int max = 0;

        for(int i=0; i<s.length(); i++){

            while(set.contains(s.charAt(i))){
                char c = q.poll();
                set.remove(c);
            }

            set.add(s.charAt(i));
            q.offer(s.charAt(i));

            max = Math.max(max, q.size());
        }

        return max;
    }
}
