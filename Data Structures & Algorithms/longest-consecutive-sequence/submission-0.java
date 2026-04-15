class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int result = 0;
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int localLength = 0;
                int value = nums[i];
                while(set.contains(value)){
                    localLength++;
                    value++;
                }
                result = Math.max(result, localLength);
            }
        }

        return result;
        
    }
}
