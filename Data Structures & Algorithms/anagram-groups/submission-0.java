class Solution {
    private String getKey(String str){
        StringBuilder sb = new StringBuilder();
        int[] alphabets = new int[26];
        for(int i=0; i<str.length(); i++){
            alphabets[str.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<26; i++){
            if(alphabets[i] != 0){
                sb.append((char)(i + 'a')).append(alphabets[i]);
            }
        }

        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return map.values().stream().toList();
        
    }
}
