class Solution {

    String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        res.add("");
        
        for(char d:digits.toCharArray()){
            List<String> temp = new ArrayList<>();
            for(String s:res){
                for(char c:numbers[d-'0'].toCharArray()){
                    temp.add(s+c);
                }
            }

            res = temp;
        }

        return res;
    }

}
