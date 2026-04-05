class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int ele : arr) {
            if(ele > 0) { // moving right
                st.push(ele);
            }
            else {
                int currMagnitude = (int)Math.abs(ele);
                boolean isSameDirection = (!st.isEmpty() && st.peek() < 0) ? true : false;

                while(!st.isEmpty() && !isSameDirection && st.peek() < currMagnitude) {
                    st.pop();
                    isSameDirection = (!st.isEmpty() && st.peek() < 0) ? true : false;
                }

                // by this time, either stack is empty or -ve element or equal/bigger element
                if(st.isEmpty()) st.push(ele);
                else if(st.peek() < 0) st.push(ele);
                else if(st.peek() == currMagnitude) st.pop();
                else continue;
            }
        }

        int res[] = new int[st.size()];

        for(int i=res.length-1;i>=0;i--) {
            res[i] = st.pop();
        }

        return res;
    }
}

/*
- insert +ve element in the stack as it is
- for -ve element : 
    - pop smaller element only if they are +ve in nature.
    - if current astroids get destroyed then continue
    - after all this, insert the current element;

    [-2,-2,1,-2]
    st = [-2

*/