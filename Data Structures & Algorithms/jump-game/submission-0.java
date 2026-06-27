class Solution {
    public boolean canJump(int[] nums) {
        int maxBoundary = 0;
        for(int i=0; i<nums.length; i++){
            maxBoundary = Math.max(maxBoundary, i + nums[i]);
            if(maxBoundary >= nums.length - 1){
                return true;
            }

            if(i >= maxBoundary){
                return false;
            }
        }

        return false;
        
    }
}
