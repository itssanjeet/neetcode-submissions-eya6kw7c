class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int n = people.length;
        Arrays.sort(people);

        int l = 0, r = n-1;
        int sum = 0;
        int res = 0;
        while(l <= r){
            sum += people[l] + people[r];
            if(sum == limit){
                res++;
                sum = 0;
                l++; r--;
            } else if(sum < limit){
                l++;
            } else {
                r--;
                sum = 0;
                res++;
            }
        }

        return res;
    }
}