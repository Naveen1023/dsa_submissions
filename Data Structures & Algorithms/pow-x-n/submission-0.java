class Solution {
    public double myPow(double x, int n) {
        double res = 1;

        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        while(n != 0) {
            if(n % 2 == 0) x = x*x;
            else {
                res *= x;
                x = x*x;
            }
            n = n/2;
        }
        return res;
    }
}
/*

*/
