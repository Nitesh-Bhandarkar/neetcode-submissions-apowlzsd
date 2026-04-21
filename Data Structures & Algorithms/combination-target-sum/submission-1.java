class Solution {
    Set<String> keys;
    private String getKey(List<Integer> nums){
        int[] freqMap = new int[31];
        for(Integer num : nums){
            freqMap[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<31; i++){
            if(freqMap[i] != 0){
                sb.append(i + "_"+freqMap[i]+"_");
            }
        }

        return sb.toString();
    }
    private void backtrack(Set<Integer> set, List<List<Integer>> result, LinkedList<Integer> tmpStore, int target, int currSum){
        if(target == currSum){
            List<Integer> subResult = new ArrayList<>(tmpStore);
            String str = getKey(subResult);
            if(!keys.contains(str)){
                keys.add(str);
                result.add(subResult);
            }   
            return;
        }

        if(target < currSum){
            return;
        }

        for(Integer element : set){
            tmpStore.add(element);
            backtrack(set, result, tmpStore, target, currSum+element);
            tmpStore.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        keys = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(set, result, new LinkedList<>(), target, 0);
        return result;
    }
}
