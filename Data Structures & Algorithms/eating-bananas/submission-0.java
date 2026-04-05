class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = (int)(1e9);
        int res = -1;
        while(left <= right) {
            int speed = left + (right-left)/2;

            long timeTaken = hoursToFinishBanana(piles, speed);

            // System.out.println("Time Taken at speed "+speed+" is : "+timeTaken);

            if(timeTaken <= h) { // bananas are finished with in time, look for better answer
                res = speed;
                right = speed-1;
            }
            else left = speed + 1;
        }

        return res;
    }

    private long hoursToFinishBanana(int arr[], int speed) {
        long timeTaken = 0;

        for(int i=0;i<arr.length;i++) {
            timeTaken +=  (int)Math.ceil((double)arr[i] / (double)speed);
            // timeTaken += (arr[i] + speed - 1)/speed;
        }
        return timeTaken;
    }
}
