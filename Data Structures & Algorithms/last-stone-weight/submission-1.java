class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }

        while(!pq.isEmpty()){
            int firstStone = pq.poll();
            if(pq.isEmpty()){
                return firstStone;
            }

            int secondStone = pq.poll();
            pq.offer(firstStone - secondStone);
        }

        return 0;
        
    }
}
