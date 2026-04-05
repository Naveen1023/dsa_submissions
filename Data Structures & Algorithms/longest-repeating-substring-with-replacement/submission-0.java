class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int f[] = new int[128];
        int res = 0;

        while(j < s.length()) {
            char ch = s.charAt(j);
            f[(int)ch]++;
            System.out.println("i = "+i+", j ="+j+", ch = "+ch+" freq[ch] = "+f[(int)ch]);
            while(!isValid(f, k)) {
                f[(int)s.charAt(i)]--;
                i++;
            }
            res = Math.max(res, j-i+1);
            System.out.println("\ti = "+i+", j ="+j+", res = "+res);
            j++;
        }
        return res;
    }

    private boolean isValid(int arr[], int k) {
        int count = 0;
        int maxFreq = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0) {
                count += arr[i];
            }
            maxFreq = Math.max(maxFreq, arr[i]);
        }
        
         System.out.println("\tcount = "+count+", maxF ="+maxFreq);

        if((count - maxFreq) > k) return false;

        return true;
    }
}
/*
AAABABB, k = 1

-> keep looking for currChar => allow only k+1 non currChar map of [key , freq]
-> for minimizing that window => keep shrinking until the #unique chars becomes <= (k+1)


*/