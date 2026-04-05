class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length-1;
        int boats = 0;

        while(i <= j) {
            int weight = people[i] + people[j];
            if(i == j) {
                boats++;
                break;
            }
            if(weight <= limit) {
                boats++;
                i++;
                j--;
            }
            else{
                boats++;
                j--;
            }
        }

        return boats;
    }
}
/*
boat carries at max 2 => [p1, p2]. p1+p2 <= limit
i,j

if i+j <= limit => send them boats++; i++, j--;
   i+j > limit => send j alone => boats++ and  j--;

   if(i=j) boat++;


*/