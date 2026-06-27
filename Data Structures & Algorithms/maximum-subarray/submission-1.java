class Solution {
    public int maxSubArray(int[] nums) {
        int localSum = 0;
        int result = Integer.MIN_VALUE;
        for(int i =0; i<nums.length; i++){
            if(localSum < 0){
                localSum = 0;          
            }

            localSum += nums[i];
            if(result < localSum){
                result = localSum;
            }
        }

        return result;
        
    }
}
