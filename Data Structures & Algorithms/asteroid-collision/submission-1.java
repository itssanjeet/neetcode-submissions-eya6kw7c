class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        for(int as: asteroids){
            while(!st.isEmpty() && as < 0 && st.peek() > 0){
                int diff = as + st.peek();
                if(diff < 0){
                    st.pop();
                } else if(diff > 0){
                    as = 0;
                } else {
                    as = 0;
                    st.pop();
                }
            }

            if(as != 0){
                st.push(as);
            }
        }

        return st.stream().mapToInt(i -> i).toArray();
    }

    private void reverse(int[] arr){
        int l = 0, r = arr.length-1;
        while(l < r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++; r--;
        }
    }
}