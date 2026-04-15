class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0; 
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[left] < nums[mid]){
                min = Math.min(Math.min(min, nums[left]), nums[right]);
                if(nums[mid] < nums[right]){
                    return min;
                }
                left = mid + 1;
            }
            else {
                min = Math.min(Math.min(min, nums[right]), nums[mid]);
                right = mid - 1;
            }
        }

        return min;
        
    }
}
