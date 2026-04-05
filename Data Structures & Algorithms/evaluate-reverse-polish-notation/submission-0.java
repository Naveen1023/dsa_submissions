class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int secondElement = Integer.parseInt(st.pop());
                int firstElement = Integer.parseInt(st.pop());
                int res = 0;
                switch(token) {
                    case "+" : 
                        res = firstElement + secondElement;
                        break;
                    case "-" : 
                        res = firstElement - secondElement;
                        break;
                    case "*" : 
                        res = firstElement * secondElement;
                        break;
                    case "/" : 
                        res = firstElement / secondElement;
                        break;
                }

                st.push(""+res);
            }
            else st.push(token);
        }

        return Integer.parseInt(st.peek());
    }
}
