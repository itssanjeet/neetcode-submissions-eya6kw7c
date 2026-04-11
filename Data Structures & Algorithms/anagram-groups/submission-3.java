class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> adj = new HashMap<>();

        for(String str:strs){
            
            int[] ch = new int[26];
            for(char c:str.toCharArray()){
                ch[c-'a']++;
            }

            String key = Arrays.toString(ch);
            adj.putIfAbsent(key, new ArrayList<>());
            adj.get(key).add(str);
        }

        System.out.println(adj);

        return new ArrayList<>(adj.values());
    }
}
