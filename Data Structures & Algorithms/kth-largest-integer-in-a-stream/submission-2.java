class KthLargest {
    int maxSize;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.maxSize = k;
        pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > maxSize){
            pq.poll();
        }

        return pq.peek();
    }
}
