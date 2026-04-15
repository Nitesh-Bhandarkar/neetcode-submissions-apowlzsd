class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int leftPoint = 0;
        int rightPoint = n-1;
        int maxVal = 0;
        while(leftPoint < rightPoint){
            int minPiller = Math.min(heights[leftPoint], heights[rightPoint]);
            maxVal = Math.max(maxVal, minPiller * (rightPoint - leftPoint));

            if(heights[leftPoint] < heights[rightPoint]){
                leftPoint++;
            }
            else{
                rightPoint--;
            }
        }

        return maxVal;
        
    }
}
