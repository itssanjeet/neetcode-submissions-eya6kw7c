class Solution {
    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    List<String> res;
    
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }

        dfs(digits, 0, "");

        return res;
    }

    private void dfs(String digits, int i, String substr){
        if(i == digits.length()){
            res.add(new String(substr));
            return;
        }

        String s = numbers[digits.charAt(i) - '0'];
        for(char c:s.toCharArray()){
            dfs(digits, i+1, substr + c);
        }
    }
}
