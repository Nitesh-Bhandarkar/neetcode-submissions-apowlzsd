class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(height[i-1], prefixMax[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(height[i+1], suffixMax[i+1]);
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result += Math.max(0, (Math.min(prefixMax[i], suffixMax[i]) - height[i]));
        }

        return result;     
    }
}
