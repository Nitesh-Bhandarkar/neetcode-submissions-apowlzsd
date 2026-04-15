class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] alphabets = new int[26];
        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            alphabets[sChar - 'a']++;
            alphabets[tChar - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(alphabets[i] != 0){
                return false;
            }
        }

        return true;

    }
}
