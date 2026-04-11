class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> adj = new HashMap<>();

        for(String str:strs){
            
            int[] ch = new int[26];
            for(char c:str.toCharArray()){
                ch[c-'a']++;
            }

            String key = "";
            for(int i=0; i<ch.length; i++){
                key += "#" + ch[i];
            }
            adj.putIfAbsent(key, new ArrayList<>());
            adj.get(key).add(str);
        }

        System.out.println(adj);

        return new ArrayList<>(adj.values());
    }
}
