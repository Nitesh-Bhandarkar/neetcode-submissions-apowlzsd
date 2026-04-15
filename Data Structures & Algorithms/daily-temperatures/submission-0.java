class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        result[n-1] = 0;
        stack.push(new int[]{temperatures[n-1], n-1});
        for(int i=n-2; i>=0; i--){
            int currTem = temperatures[i];
            if(currTem < stack.peek()[0]){
                result[i] = stack.peek()[1] - i;
            }
            else{
                while(!stack.isEmpty() && currTem >= stack.peek()[0]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    result[i] = 0;
                }
                else{
                    result[i] = stack.peek()[1] - i;
                }
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return result;
    }
}
