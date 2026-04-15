class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('_').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while(idx < str.length()){
            StringBuilder sb = new StringBuilder();
            int digitIdx = idx;
            while(digitIdx < str.length() && Character.isDigit(str.charAt(digitIdx))){
                sb.append(str.charAt(digitIdx));
                digitIdx++;         
            }
            int length = Integer.parseInt(sb.toString());
            int startIdx = idx+sb.length() + 1;
            int endIdx = startIdx + length;
            result.add(str.substring(startIdx, endIdx));
            idx = endIdx;
        }

        return result;

    }
}
