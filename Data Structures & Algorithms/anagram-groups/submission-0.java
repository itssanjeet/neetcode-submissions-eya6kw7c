class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> adj = new HashMap<>();

        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            adj.putIfAbsent(key, new ArrayList<>());
            adj.get(key).add(str);
        }

        return new ArrayList<>(adj.values());
    }
}
