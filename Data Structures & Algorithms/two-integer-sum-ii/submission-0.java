class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPoint = 0;
        int rightPoint = numbers.length-1;
        while(leftPoint < rightPoint){
            int sum = numbers[leftPoint] + numbers[rightPoint];
            if(sum == target){
                return new int[]{leftPoint+1, rightPoint+1};
            }

            if(sum < target){
                leftPoint++;
            }
            else{
                rightPoint--;
            }

        }

        return new int[]{};
        
    }
}
