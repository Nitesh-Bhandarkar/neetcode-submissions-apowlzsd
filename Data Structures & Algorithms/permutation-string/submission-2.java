class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] baseAlphabets = new int[26];
        for(int i=0; i<s1.length(); i++){
            baseAlphabets[s1.charAt(i) - 'a']++;
        }

        int len = s1.length();
        int left = 0;
        int[] freqCheck = new int[26];
        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(baseAlphabets[ch - 'a'] == 0){
                while(left <= i){
                    freqCheck[s2.charAt(left) - 'a'] = 0;
                    left++;
                }
                continue;
            }

            freqCheck[ch - 'a']++;
            System.out.println(i + "_"+ left);
            if(i-left+1 == len && (Arrays.compare(freqCheck, baseAlphabets) == 0)){
                return true;
            }
            else if(i-left+1 >= len){
                freqCheck[s2.charAt(left) - 'a']--;
                left++;
            }   
        }

        return (Arrays.compare(freqCheck, baseAlphabets) == 0);
    }
}
