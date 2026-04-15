class Solution {
    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int result = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > minVal){
                result = Math.max(result, prices[i] - minVal);
            }
            minVal = Math.min(minVal, prices[i]);
        }

        return result;
        
    }
}
