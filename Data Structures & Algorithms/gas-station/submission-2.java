class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int runningSum = 0;
        int totalSum = 0;
        for(int i=0; i<gas.length; i++){
            int diff = gas[i] - cost[i];
            totalSum += diff;
            runningSum += diff;
            if(runningSum < 0){
                runningSum = 0;
                idx = i+1;
            }
        }

        return (totalSum >= 0) ? idx : -1;
        
    }
}
