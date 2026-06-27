class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] charIdxStore = new int[26];
        for(int i=0; i<s.length(); i++){
            charIdxStore[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int boundary = charIdxStore[s.charAt(0) - 'a'];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(i == boundary){
                result.add(i - start + 1);
                start = i + 1;
                if(i < s.length() -1){
                    boundary = charIdxStore[s.charAt(i+1) - 'a'];
                }
                
            }
            char ch = s.charAt(i);
            boundary = Math.max(boundary, charIdxStore[ch - 'a']);
        }

        return result;
        
    }
}
