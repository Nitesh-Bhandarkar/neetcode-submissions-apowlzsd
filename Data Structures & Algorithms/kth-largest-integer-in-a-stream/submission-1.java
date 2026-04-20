class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((o1, o2)->o1-o2);
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }

        return pq.peek();
    }
}
