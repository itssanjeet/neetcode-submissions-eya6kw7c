class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        for(int r=0; r<n; r++){
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[r]){
                q.pollLast();
            }
            q.addLast(r);

            if(r < k-1){
                continue;
            }

            if(q.peekFirst() < l){
                q.pollFirst();
            }

            res[l] = nums[q.peekFirst()];
            l++;
        }

        return res;
    }
}
