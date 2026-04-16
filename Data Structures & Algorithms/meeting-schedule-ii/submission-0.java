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
    public int minMeetingRooms(List<Interval> list) {
        // Collections.sort(list, (a,b) -> a.get(0) - b.get(0));
        int res = 0;
        int sum = 0;
        int arr[] = new int[1000001];

        for(Interval interval : list) {
            arr[interval.start]++;
            arr[interval.end]--;
        }

        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            res = Math.max(res, sum);
        }

        return res;
    }
}
