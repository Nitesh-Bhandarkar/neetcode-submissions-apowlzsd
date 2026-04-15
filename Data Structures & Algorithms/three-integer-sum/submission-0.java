class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            int num = nums[i];
            int target = -nums[i];
            int leftPoint = i+1;
            int rightPoint = n - 1;
            while(leftPoint < rightPoint){
                int sum = nums[leftPoint] + nums[rightPoint];
                if(sum == target){
                    String key = nums[i]+ "_"+nums[leftPoint]+"_"+nums[rightPoint];
                    if(!set.contains(key)){
                        result.add(List.of(nums[i], nums[leftPoint], nums[rightPoint]));
                    }

                    set.add(key);
                    
                    leftPoint++;
                    rightPoint--;
                }
                else if(sum < target){
                    leftPoint++;
                }
                else{
                    rightPoint--;
                }
            }
        }

        return result;
        
    }
}
