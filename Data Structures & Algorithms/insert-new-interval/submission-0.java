class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;
        ArrayList<int []> list = new ArrayList<>();


        while(index < intervals.length) {
            int curr[] = intervals[index];
            int x = curr[0];
            int y = curr[1];


            if(end < x) { // no overlap, insert at index-1 position
                list.add(new int[]{start, end});
                inserted = true;
                break;
            }
            else if(start > y) { // no overlap, check with next interval
                list.add(curr);
            }
            else { // overlap
                start = Math.min(start, x);
                end = Math.max(end, y);
            }
            index++;
        }

        if(inserted == false) {
            list.add(new int[]{start, end});
        }

        while(index < intervals.length) {
            list.add(intervals[index++]);
        }


        int res[][] = new int[list.size()][2];
        int resIndex = 0;
        for(int ele[] : list) {
            res[resIndex++] = ele;
        }
        return res;
    }
}

/*
x,y

(,),(,),(,),(,),(,)

(i,j)

if(y < i) => insert at (i-1)th position; inserted = true : break;
else if (x > j) => no overlap with current interval => move to the next one
else { 
    x = min(x, i);
    y = max(y, j);
    i++;
}
*/