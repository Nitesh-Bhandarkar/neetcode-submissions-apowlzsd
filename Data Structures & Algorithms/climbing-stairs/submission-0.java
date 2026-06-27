class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int firstStepCount = 1;
        int secondStepCount = 2;
        int result = 0;

        for(int i=3; i<=n ; i++){
            result = firstStepCount + secondStepCount;
            firstStepCount = secondStepCount;
            secondStepCount = result;
        }

        return result;
        
    }
}
