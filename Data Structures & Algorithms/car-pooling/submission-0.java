class Solution {
    public boolean carPooling(int[][] arr, int capacity) {
        int passengers[] = new int[1001];

        // System.out.println(Arrays.toString(passengers));

        for(int a[] : arr) {
            int from = a[1];
            int to = a[2];
            passengers[from] += a[0]; // passengers getting added at that location
            passengers[to] -= a[0]; // passengers are dropped off
            // System.out.println("passengers[from] : "+passengers[from]+", passengers[to] : "+passengers[to]+" from : "+from+", to : "+to);
        }

        // System.out.println("\n\n\n"+Arrays.toString(passengers));

        for(int i=0;i<passengers.length;i++) {
            if(i > 0)
                passengers[i] += passengers[i-1];

            if(passengers[i] > capacity) return false;
        }
        return true;

    }
}
/*
- sort in asc order of pickup location
- start picking the left most ones
- as soon as capacity gets over and passanger are still there => return false;
- if we are able to reach till end of the array => true


1 2   3 4
4 0
  
*/