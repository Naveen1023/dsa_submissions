class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int res = -1;

        int l=Integer.MIN_VALUE, r=0;
        
        for(int w : weights) {
            l = Math.max(l , w);
            r += w;
        }

        while(l <= r) {
            int mid = (l+r)/2;

            // check if mid is the answer
            int daysTaken = countDays(weights, mid);

            // System.out.println("cap : "+mid+", daysTaken : "+daysTaken);

            if(daysTaken <= days) {
                res = mid;
                r = mid - 1;
            }
            else l = mid+1;
        }

        return res;
    }

    private int countDays(int arr[], int cap) {
        int cnt = 1;
        int currW = 0;
        
        for(int i=0;i<arr.length;i++){
            if((currW + arr[i]) <= cap){
                currW += arr[i];
            }      
            else{
                currW = arr[i];
                cnt++;
            }
        }        
        return cnt;
    }
}