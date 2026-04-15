class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int num : nums){
            if(num == 0){
                zeroCount++;
                continue;
            }
            product *= num;
        }

        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(zeroCount == 1){
                    result[i] = product;
                }
                else{
                    result[i] = 0;
                }
                
            }
            else{
                if(zeroCount >= 1){
                    result[i] = 0;
                }
                else{
                    result[i] = product / nums[i];
                }
            }
        }

        return result;
        
    }
}  
