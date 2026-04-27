class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        int idx = 1;
        int length = 1;
        for(int i=0; i<length && idx <= n; i++){
            result[idx] = result[i]+1;
            idx++;
            if(i == length-1){
                i=-1;
                length = idx;
            }
        }

        return result;
        
    }
}
