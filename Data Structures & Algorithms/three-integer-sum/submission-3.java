class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int num = nums[i];
            if(num > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // int target = -;
            int leftPoint = i+1;
            int rightPoint = n - 1;
            while(leftPoint < rightPoint){
                int sum = nums[leftPoint] + nums[rightPoint] + nums[i];
                if(sum < 0){
                    leftPoint++;
                }
                else if(sum > 0){
                    rightPoint--;
                }
                else{
                    result.add(List.of(nums[i], nums[leftPoint], nums[rightPoint]));
                    
                    leftPoint++;
                    rightPoint--;
                    while(leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint-1]){
                        leftPoint++;
                    }
                }

                
            }
        }

        return result;
        
    }
}
