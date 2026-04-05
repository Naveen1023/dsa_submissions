class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        solve(0,0,n,new StringBuilder());

        return res;
    }

    private void solve(int open, int closed, int max, StringBuilder str) {

        if(open == max && closed == max) {
            res.add(str.toString());
            return;
        }
        
        if(open < max) {
             solve(open+1, closed, max, str.append("("));
             str.deleteCharAt(str.length()-1);
        }
           

        if(closed < open) {
            solve(open, closed+1, max, str.append(")"));
            str.deleteCharAt(str.length()-1);
        }
    }
}

/*
3
(())()
open = 3
closed = 3

open == closed == n

solve(open, closed, n) {
    if open < n:
        can place open
        or
        if(closed < open) : 
            can place closed bracket

    else :
        if closed < n :
            can place closed
}

n = 3
f(0,0,3,"")
    f(1,0,3,"(")
        f(2,0,3, "((")
            f(3,0,3,"(((")

            f(2,1,3,"(()")
        f(1,1,3,"()")



*/
