class Solution {
    private boolean isValid(Map<Character, Integer> freqMap, Map<Character, Integer> freqMap2){
        for(Character ch : freqMap.keySet()){
            if(freqMap2.getOrDefault(ch, 0) < freqMap.get(ch)){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        Queue<Integer> indexQueue = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            if(freqMap.containsKey(s.charAt(i))){
                indexQueue.offer(i);
            }
        }

        if(indexQueue.isEmpty()){
            return "";
        }

        int leftIdx = indexQueue.poll();
        int minWindow = Integer.MAX_VALUE;
        String minString = "";
        Map<Character, Integer> freqMap2 = new HashMap<>();
        int rightIdx = leftIdx;
        do{
            char ch = s.charAt(rightIdx);
            if(!freqMap.containsKey(ch)){
                rightIdx++;
                continue;
            }

            freqMap2.put(ch, freqMap2.getOrDefault(ch, 0)+1);
            if(isValid(freqMap, freqMap2)){
                if(minWindow > rightIdx - leftIdx + 1){
                    minWindow = rightIdx - leftIdx + 1;
                    minString = s.substring(leftIdx, rightIdx+1);  
                }
                char leftCh = s.charAt(leftIdx);
                freqMap2.put(leftCh, freqMap2.get(leftCh)-1);
                freqMap2.put(ch, freqMap2.get(ch)-1);
                if(!indexQueue.isEmpty()){
                    leftIdx =  indexQueue.poll();
                }
            }
            else{
                rightIdx++;
            }
        }
        while(rightIdx < s.length());

        return minString;        
    }
}
