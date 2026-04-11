class Solution {

    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if(digits.length() == 0){
            return res;
        }

        solve(digits, 0, "", res);
        return res;
    }

    private void solve(String digits, int idx, String s, List<String> res){
        if(idx == digits.length()){
            res.add(new String(s));
            return;
        }

        String str = numbers[digits.charAt(idx)-'0'];

        for(char c:str.toCharArray()){
            solve(digits, idx+1, s + c, res);
        }
    }
}
