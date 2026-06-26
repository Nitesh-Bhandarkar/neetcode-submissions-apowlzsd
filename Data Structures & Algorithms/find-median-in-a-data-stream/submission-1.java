class MedianFinder {
    PriorityQueue<Integer> leftEntries;
    PriorityQueue<Integer> rightEntries;

    public MedianFinder() {
        leftEntries = new PriorityQueue<>(Comparator.reverseOrder());
        rightEntries = new PriorityQueue<>(Integer::compareTo);
        
    }
    
    public void addNum(int num) {
        if(!leftEntries.isEmpty() && leftEntries.peek() < num){
            rightEntries.offer(num);
            if(rightEntries.size() > leftEntries.size() + 1){
                leftEntries.offer(rightEntries.poll());
            }
        }
        else{
            leftEntries.offer(num);
            if(leftEntries.size() > rightEntries.size() + 1){
                rightEntries.offer(leftEntries.poll());
            }
        }

    }
    
    public double findMedian() {
        int leftSize = leftEntries.size();
        int rightSize = rightEntries.size();

        if(leftSize == rightSize && leftSize != 0){
            return (leftEntries.peek() + rightEntries.peek()) / 2.00;
        }

        if(leftSize > rightSize){
            return leftEntries.peek();
        }

        return (rightSize != 0) ? rightEntries.peek() : 0; 
        
    }
}
