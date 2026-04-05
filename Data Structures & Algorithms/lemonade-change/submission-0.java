class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;


        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5) { // just take it, update the balance
                countFive++;
            }
            else if(bills[i] == 10) { // need to give back one five 
                if(countFive <= 0) return false;
                countFive--;
                countTen++;
            }
            else { // 20 rs=> need to give 15 back, (either 3 Fives), (1 five + 1 Ten)
                if(countTen > 0) {
                    countTen--;
                    if(countFive > 0) countFive--;
                    else return false;
                }
                else {
                    if(countFive >= 3) countFive -= 3;
                    else return false;
                }
            }
        }

        return true;
    }
}