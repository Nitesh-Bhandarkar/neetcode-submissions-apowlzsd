class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int[] freq = new int[26];
        int maxCount = 0;
        int result = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            maxCount = Math.max(maxCount, freq[ch - 'A']);
            if(i-l+1 > maxCount + k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            result = Math.max(result, i - l +1);
        }

        return result;
        
    }
}
