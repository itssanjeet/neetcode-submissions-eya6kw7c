class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n-k+1];
        int l = 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int r=0; r<n; r++){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }
            queue.addLast(r);

            if(l > queue.getFirst()){
                queue.removeFirst();
            }

            if((r+1) >= k){
                res[l] = nums[queue.getFirst()];
                l++;
            }
        }

        return res;
    }
}
