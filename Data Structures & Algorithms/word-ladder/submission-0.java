class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        int dist = 1;

        q.offer(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0;i<size;i++) {
                String curr = q.poll();
                System.out.println("curr : "+curr+" at dist : "+dist);
                // bfs on all the neighbours which are 1 character away
                if(curr.equals(endWord)) return dist;
                for(String neigh : wordList) {
                    if(!validNeigh(curr, neigh) || visited.contains(neigh)) continue;
                    q.offer(neigh);
                    visited.add(neigh);
                }
            }
            dist++;
        }
        return 0;
    }

    private boolean validNeigh(String s1, String s2) {
        int diff = 0;
        if(s1.length() != s2.length()) return false;

        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if(diff > 1) return false;
            }
        }
        return true;
    }


}
