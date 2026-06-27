class Solution {
    public int jump(int[] nums) {
        int maxBoundary = 0;
        int jumpCount = 0;
        int localMaxBoundary = 0;
        for(int i=0; i<nums.length; i++){
            if(maxBoundary >= nums.length - 1){
                return jumpCount;
            }
            localMaxBoundary = Math.max(localMaxBoundary, i+nums[i]);
            if(i == maxBoundary){
                jumpCount++;
                maxBoundary = localMaxBoundary;
            } 
        }

        return 0;
        
    }
}
