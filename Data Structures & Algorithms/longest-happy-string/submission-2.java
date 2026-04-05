class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int []> pq = new PriorityQueue<>((l,m) -> (l[1] == m[1]) ? l[0]-m[0]: m[1]-l[1]);
        StringBuilder str = new StringBuilder("");
        int occuranceOfPrevCharTillNow = 0;
        int prevChar = -1;

        if(a > 0) pq.offer(new int[]{0,a});
        if(b > 0) pq.offer(new int[]{1,b});
        if(c > 0) pq.offer(new int[]{2,c});

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            // System.out.println("curr is popped : "+Arrays.toString(curr));

            if((curr[0] != prevChar) || (occuranceOfPrevCharTillNow + 1) < 3) { // (same and less than 3) OR (diff)
                str.append(curr[0]);
                curr[1]--;
                if(curr[1] > 0) pq.offer(curr);

                occuranceOfPrevCharTillNow = (curr[0] == prevChar) ? occuranceOfPrevCharTillNow+1 : 1;
                prevChar = curr[0];
            }
            else { // place the 2nd pop
                if(pq.isEmpty()) break;
                int curr2[] = pq.poll();

                str.append(curr2[0]);
                curr2[1]--;
                if(curr2[1] > 0) pq.offer(curr2);

                pq.offer(curr); // insert back the original one also

                prevChar = curr2[0];
                occuranceOfPrevCharTillNow = 1;
                // System.out.println("\tcurr2 is popped : "+Arrays.toString(curr2));
            }

            // System.out.println("\tafter iteration str: "+str.toString()+", occurance : "+occuranceOfPrevCharTillNow+", prevChar : "+prevChar);
        }

        // System.out.println("str : "+str.toString());

        StringBuilder res = new StringBuilder("");

        for(int i=0;i<str.length();i++) {
            char temp = 'a';
            if(str.charAt(i) == '1') temp = 'b';
            else if(str.charAt(i) == '2')temp = 'c';

            res.append(temp);
        }

        // System.out.println("res : "+res.toString());

        return res.toString();

    }
}
/*
1) 
    longest <= a+b+c

    _ _ _ _ _ 
    3^n * n

2) c=5, b=1, a=0
    cc

    a=0,b=0,c=0
    bababcabc

    first encounter => place
    second => place
    third => skip this and choose next option.
*/