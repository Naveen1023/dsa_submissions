class Solution {
    public List<Integer> majorityElement(int[] arr) {
                int res1 = (int)(1e9)+1;
        int res2 = (int)(1e9)+1;
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int ele : arr) {
            if(ele == res1) { // check this candidate
                cnt1++;
            }
            else if(ele == res2) { // check this candidate
                cnt2++;
            }
            else if(cnt1 == 0) {
                res1 = ele;
                cnt1 = 1;
            }
            else if(cnt2 == 0) {
                res2 = ele;
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        int actualcnt1 = 0;
        int actualcnt2 = 0;
        int threshold = (int)Math.floor(arr.length/3);
        for(int ele : arr) {
            if(ele == res1) actualcnt1++;
            else if(ele == res2) actualcnt2++;
        }

        List<Integer> res = new ArrayList<>();
        if(actualcnt1 > threshold) res.add(res1);
        if(actualcnt2 > threshold) res.add(res2);

        return res;
    }
}

/*
n
n/3

*/