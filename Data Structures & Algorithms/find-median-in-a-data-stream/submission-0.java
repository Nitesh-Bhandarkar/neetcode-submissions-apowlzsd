class MedianFinder {
    PriorityQueue<Integer> maxQ;
    PriorityQueue<Integer> minQ;

    public MedianFinder() {
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxQ.isEmpty() || num <= maxQ.peek()){
            maxQ.offer(num);
            while(Math.abs(maxQ.size() - minQ.size()) > 1){
                minQ.offer(maxQ.poll());
            }
        }
        else{
            minQ.offer(num);
            while(Math.abs(maxQ.size() - minQ.size()) > 1){
                maxQ.offer(minQ.poll());
            }
        }
        
    }
    
    public double findMedian() {
        if(maxQ.size() == minQ.size()){
            return (maxQ.peek() + minQ.peek()) / 2.00;
        }

        if(maxQ.size() > minQ.size()){
            return (double) maxQ.peek();
        }

        return (double) minQ.peek();
        
    }
}
