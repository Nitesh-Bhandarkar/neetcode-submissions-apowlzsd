class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int n = heights.length;
        int max = 0;
        for(int i=0; i<n; i++){
            int index = i;
            while(!stack.isEmpty() && stack.peek()[0] >= heights[i]){
                int[] polledElement = stack.pop();
                index = polledElement[1];
                max = Math.max(max, polledElement[0] * (i - polledElement[1]));
            }
            stack.push(new int[]{heights[i], index});
        }

        while(!stack.isEmpty()){
            int[] polledElement = stack.pop();
            max = Math.max(max, polledElement[0] * (n - polledElement[1]));

        }

        return max;
        
    }
}
