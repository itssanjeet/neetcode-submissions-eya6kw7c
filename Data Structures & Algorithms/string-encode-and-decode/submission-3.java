class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0){
            return "";
        }

        List<Integer> sizes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length()).append(",");
        }

        sb.append("#");
        for(String s:strs){
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if(str.isEmpty()){
            return res;
        }

        List<Integer> sizes = new ArrayList<>();
        int idx = 0;
        while(str.charAt(idx) != '#'){
            String s = "";
            while(str.charAt(idx) != ','){
                s += str.charAt(idx);
                idx++;
            }
            sizes.add(Integer.parseInt(s));
            idx++;
        }
        idx++;

        for(int size:sizes){
            res.add(str.substring(idx, idx+size));
            idx += size;
        }

        return res;
    }
}
