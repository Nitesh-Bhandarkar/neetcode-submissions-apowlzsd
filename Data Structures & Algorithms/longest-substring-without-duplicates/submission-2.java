class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int leftPoint = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= leftPoint){
                maxLength = Math.max(maxLength, i-leftPoint);
                leftPoint = map.get(ch) + 1;
            }

            map.put(ch, i);
        }

        return Math.max(maxLength, s.length()-leftPoint);      
    }
}
