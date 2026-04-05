class Solution {
    public String simplifyPath(String path) {
              String arr[] = path.split("/");
        /**
            if ele is length 0 => means slash, push
            if ele startswith . => 
                if length == 2 => pop
                otherwise => continue; 
         */

        Stack<String> st = new Stack<>();

        for (String s : arr) {
            if (s.length() == 0 || s.equals(".")) { // it's a slash
            } else if (s.equals("..")) {
                if (!st.isEmpty())
                    st.pop();
            } else
                st.push(s);
            //     System.out.println("Stack Size : "+st.size());
        }

        // System.out.println("Splitted Array : " + Arrays.toString(arr));
        // System.out.println("Stack Size : " + st.size());

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            String temp = "/" + st.pop();
            res.insert(0, temp);
        }
        return (res.length() == 0) ? "/" : res.toString();
    }
}