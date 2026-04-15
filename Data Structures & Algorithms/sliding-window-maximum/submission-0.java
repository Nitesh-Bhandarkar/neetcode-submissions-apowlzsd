class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int[] result = new int[nums.length - k + 1];
        for(int i=0; i<k-1; i++){
            pq.offer(new int[]{nums[i], i});
        }

        for(int i=k-1; i<nums.length; i++){
            int leftBound = i-k;
            pq.offer(new int[]{nums[i], i});
            while(pq.peek()[1] <= leftBound){
                pq.poll();
            }
            
            result[i-k+1] = pq.peek()[0]; 
        }

        return result;
        
    }
}
