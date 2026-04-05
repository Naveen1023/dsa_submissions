class Solution {
    public int numDecodings(String s) {
        return decode(0, s);
    }

    public static int decode(int index, String str) {
        if(index >= str.length()){
            // System.out.println("call here...with index : "+index);
            return 1;
        }

        // System.out.println("index : "+index+" current String : "+str.substring(index));
        int totalWays = 0;
        int current = Integer.parseInt(str.substring(index, index+1));
        int currentAndNext = 100;
        if(index+1 < str.length()){
            currentAndNext = Integer.parseInt(str.substring(index, index+2));
        }

        if(current == 0) return 0;
        else totalWays += decode(index+1, str);
        
        if(currentAndNext <= 26)
            totalWays += decode(index+2, str);

        return totalWays;
    }
}

/*
Range : 1 to 26
15327436

O(2^n)

recursive : 
    at every index : 
        take current number and decode current and decode(rest)
        + 
        take (current index + next index) if <= 26 and decode(rest)
*/
