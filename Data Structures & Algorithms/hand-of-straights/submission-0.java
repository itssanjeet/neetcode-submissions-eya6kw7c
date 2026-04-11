class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0){
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int h:hand){
            count.put(h, count.getOrDefault(h, 0)+1);
        }

        Arrays.sort(hand);

        for(int h:hand){
            if(count.get(h) > 0){
                for(int i=h; i < h+groupSize; i++){
                    if(count.getOrDefault(i, 0) == 0)
                        return false;

                    count.put(i, count.get(i)-1);
                }
            }
        }

        return true;
    }
}
