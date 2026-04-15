class Solution {
    public int largestRectangleArea(int[] heights) {
        int max =0;
        int n = heights.length;
    
        for(int i=0; i<n; i++){
            int currHeight = heights[i];
            int area = currHeight;
            //Left
            for(int j=i-1 ; j>=0 && heights[j] >= currHeight; j--){
                area += currHeight;
            }

            //Right
            for(int j=i+1 ; j<n && heights[j] >= currHeight; j++){
                area += currHeight;
            }
            max =Math.max(max, area);
        }

        return max;   
    }
}
