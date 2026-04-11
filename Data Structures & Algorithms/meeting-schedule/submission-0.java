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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        int preEnd = Integer.MIN_VALUE;
        for(Interval i:intervals){
            if(i.start < preEnd){
                return false;
            }

            preEnd = i.end;
        }

        return true;
    }
}
