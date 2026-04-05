class Solution {
    public int leastInterval(char[] tasks, int n) {
        int f[] = new int[26];
        
        for(char ch : tasks) {
            f[ch - 'A']++;
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]); // max heap on freq
        Queue<int []> q = new LinkedList<>();

        for(int i=0;i<f.length;i++) {
            if(f[i] > 0)
                pq.offer(new int[]{i, f[i]}); // character, freq of character
        }

        int time = 1;
        while(!pq.isEmpty() || !q.isEmpty()) {
            System.out.println("time : "+time);
            if(!q.isEmpty()) {
                if(q.peek()[1] <= time) {
                    int first[] =  q.poll();
                    pq.offer(new int[]{first[2], first[0]});
                    continue;
                }
            }

            if(pq.isEmpty()) {
                time = q.peek()[1]; // set to next avaiable time
                continue;
            }

            int maxFChar[] = pq.poll();
            //insert this char at time location, and mark that as done => time++
            // now freq-1 for this char after cooldown period
            int newFreq = maxFChar[1]-1;
            if(newFreq > 0) q.offer(new int[]{newFreq, time+n+1, maxFChar[0]}); // char , new frequency, next available time for scheduling...
            time++;
        }
        return time-1;
    }
}
/*
XXYY
X Y _ X Y


AAABC
A B _ _ A _ _ _ A
*/