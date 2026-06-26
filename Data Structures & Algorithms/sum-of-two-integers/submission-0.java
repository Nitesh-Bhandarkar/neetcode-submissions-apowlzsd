class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int pos = 0;
        int s = 0;
        int c = 0;
       
        for(int i=0; i<32; i++){
            int aBit = a & 1;
            int bBit = b & 1;
            s = aBit ^ bBit ^ c;
            c = (c & (aBit ^ bBit)) | (aBit & bBit);
            a = a >> 1;
            b = b >> 1;
            
            if(s == 1){
                int mask = 1 << pos;
                result = result | mask;
            }
            pos++; 
        }

        return result;
        
    }
}
