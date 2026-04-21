class Solution {
    private void backTrack(int[] nums, int startIdx, List<List<Integer>> result, LinkedList<Integer> tempStore){
        result.add(new ArrayList<>(tempStore));
        for(int i = startIdx; i<nums.length; i++){
            tempStore.add(nums[i]);
            backTrack(nums, i+1, result, tempStore);
            tempStore.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, result, new LinkedList<>());
        return result;
    }
}
