class Solution {
    public int hammingWeight(int n) {
        int oneCount  = 0;
        while(n != 0){
            if((n & 1) == 1){
                oneCount++;
            }

            n = n >> 1;
        }

        return oneCount;
        
    }
}
