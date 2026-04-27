class Solution {
    private void backtrack(int[] nums, LinkedList<Integer> store, List<List<Integer>> result, boolean[] visited){
        if(store.size() == nums.length){
            result.add(new ArrayList<>(store));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            store.add(nums[i]);
            backtrack(nums, store, result, visited);
            visited[i] = false;
            store.removeLast();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visitedIdx = new boolean[nums.length];
        backtrack(nums, new LinkedList<>(), result, visitedIdx);
        return result;  
    }
}
