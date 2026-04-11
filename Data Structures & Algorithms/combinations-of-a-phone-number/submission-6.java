class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(digits.length() == 0){
            return res;
        }

        res.add("");

        for(char d : digits.toCharArray()){
            List<String> list = new ArrayList<>();

            for(char c: numbers[d - '0'].toCharArray()){
                for(String s:res){
                    list.add(s + c);
                }
            }
            res = list;
            System.out.println(res);
        }

        return res;
    }
}
