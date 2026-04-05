class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = nums[0];
        int votes = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != majorityElement){ 
                votes--;
                if(votes == 0) {
                    majorityElement = nums[i];
                    votes = 1;
                }
            }
            else votes++;
        }

        return (votes >= 1) ? majorityElement : Integer.MAX_VALUE;

    }
}
