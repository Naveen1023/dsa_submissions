class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        int dist = 0;

        for (String str : deadends) {
            set.add(str);
        }
        if (set.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                String currStr = q.poll();
                if (currStr.equals(target))
                    return dist;
                

                //find all the neighbours => 0000 : 0001, 0010, 0100, 1000, and only add valid ones (which are not the deadends)
                char curr[] = currStr.toCharArray();

                for (int i = 0; i < 4; i++) {
                    char originalChar = curr[i];
                    char inc = (curr[i] == '9') ? '0' : (char)(curr[i] + 1);
                    char dec = (curr[i] == '0') ? '9' : (char)(curr[i] - 1);
                
                    curr[i] = inc;
                    String neigh1 = new String(curr);

                    curr[i] = dec;
                    String neigh2 = new String(curr);

                    if(!visited.contains(neigh1) && !set.contains(neigh1)) {
                        q.offer(neigh1);
                        visited.add(neigh1);
                    }

                    if(!visited.contains(neigh2) && !set.contains(neigh2)) {
                        q.offer(neigh2);
                        visited.add(neigh2);
                    }

                    curr[i] = originalChar;
                }
            }
            dist++;
        }

        return -1;
    }
}