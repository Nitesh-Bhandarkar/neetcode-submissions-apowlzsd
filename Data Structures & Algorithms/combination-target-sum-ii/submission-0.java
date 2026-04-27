class Solution {
    private void backtrack(List<Integer> elements, 
    Map<Integer, Integer> map, int target, int currSum, List<List<Integer>> result, LinkedList<Integer> store, int idx){
        if(currSum > target){
            return;
        }
        if(currSum == target){
            result.add(new ArrayList(store));
            return;
        }

        for(int i=idx; i<elements.size(); i++){
            int key = elements.get(i);
            int availableCount = map.get(key);
            if(availableCount == 0){
                continue;
            }

            map.put(key, availableCount-1);
            store.add(key);
            backtrack(elements, map, target, currSum + key, result, store, i);
            map.put(key, availableCount);
            store.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int can : candidates){
            freqMap.put(can, freqMap.getOrDefault(can, 0)+1);
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(freqMap.keySet()), freqMap, target, 0, result, new LinkedList<>(), 0);
        return result; 
    }
}
