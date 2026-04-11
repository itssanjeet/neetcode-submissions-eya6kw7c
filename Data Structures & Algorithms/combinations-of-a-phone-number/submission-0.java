class Solution {

    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }

        dfs(digits, 0, "", res);
        return res;
    }

    private void dfs(String digits, int i, String curr, List<String> res){
        if(i >= digits.length()){
            res.add(new String(curr));
            return;
        }

        String s = numbers[digits.charAt(i)-'0'];

        for(char c:s.toCharArray()){
            dfs(digits, i+1, curr+c, res);
        }
    }
}
