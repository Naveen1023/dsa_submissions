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
    public boolean canAttendMeetings(List<Interval> list) {
        Collections.sort(list, (a,b) -> a.start - b.start);
        if(list.size() == 0) return true;
        int start = list.get(0).start;
        int end = list.get(0).end;
        int index = 1;

        while(index < list.size()) {
            Interval curr = list.get(index);

            if(curr.start < end) { // means there is overlap
                return false;
            }
            start = curr.start;
            end = curr.end;
            index++;
        }
        return true;
    }
}
