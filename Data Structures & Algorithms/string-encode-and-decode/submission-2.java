class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }

        List<Integer> sizes = new ArrayList<>();
        for(String s:strs){
            sizes.add(s.length());
        }

        StringBuilder sb = new StringBuilder();
        for(int size:sizes){
            sb.append(String.valueOf(size)).append(",");
        }
        sb.append("#");
        for(String s:strs){
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }

        System.out.println(str);
        List<Integer> sizes = new ArrayList<>();
        int idx = 0;
        while(str.charAt(idx) != '#'){
            StringBuilder sb = new StringBuilder();
            while(str.charAt(idx) != ','){
                sb.append(str.charAt(idx));
                idx++;
            }

            sizes.add(Integer.parseInt(sb.toString()));
            idx++;
        }


        List<String> res = new ArrayList<>();
        idx++;
        for(int size:sizes){
            res.add(str.substring(idx, idx+size));
            idx += size;
        }

        return res;
    }
}
