class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int res[] = new int[temp.length];
        Stack<Integer> st = new Stack<>();

        res[res.length-1] = 0;
        st.push(res.length-1);

        for(int i=temp.length-2;i>=0;i--) {
            int currTemp = temp[i];

            while(!st.isEmpty() && temp[st.peek()] <= currTemp) {
                st.pop();
            }
            if(!st.isEmpty()) res[i] = st.peek()-i;
            else res[i] = 0;
            
            st.push(i);
            // System.out.println("i : "+i+", st top : "+temp[st.peek()]+" st.size() : "+st.size());
        }

        return res;
    }
}
