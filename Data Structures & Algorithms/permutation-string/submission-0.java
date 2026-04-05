class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int f1[] = new int[26];
        int f2[] = new int[26];

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            f1[ch - 'a']++;
        }


        int j = 0;
        int k = 0;
        while(k < s2.length()) {
            if(k-j+1 < s1.length()) {
                f2[s2.charAt(k) - 'a']++;
                k++;
                continue;
            }
            //we are at equal size substring
            f2[s2.charAt(k) - 'a']++;
            if(isValid(f1,f2)) {
                return true;
            }

            f2[s2.charAt(j++) - 'a']--;
            k++;
        }

        return false;
    }

    private boolean isValid(int arr1[] , int arr2[]) {
        for(int i=0;i<26;i++) {
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}
