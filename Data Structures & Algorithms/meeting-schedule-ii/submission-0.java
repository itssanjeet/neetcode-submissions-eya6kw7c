/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        int res = 0;
        while(intervals.size() > 0){
            res++;
            int preEnd = intervals.get(0).end;
            intervals.remove(0);

            for(int i=0; i<intervals.size(); i++){
                Interval interval = intervals.get(i);
                if(interval.start >= preEnd){
                    preEnd = interval.end;
                    intervals.remove(i);
                    i--;
                }
            }
        }

        return res;
    }
}
