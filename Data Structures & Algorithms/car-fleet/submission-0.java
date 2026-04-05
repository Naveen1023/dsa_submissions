class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int cars[][] = new int[pos.length][2];
        int fleets = 0;
        double prevTime = 0;

        for(int i=0;i<pos.length;i++) {
            cars[i][0] = pos[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> a[0]-b[0]); // sorted by position....


        for(int i=cars.length-1;i>=0;i--){
            double timeTaken = (double)(target - cars[i][0])/(double)cars[i][1];

            if(timeTaken > prevTime) { // this car will reach faster so it;s not the part of previous fleet
                fleets++;
                prevTime = timeTaken;
            }
        }

        return fleets;
    }
}
