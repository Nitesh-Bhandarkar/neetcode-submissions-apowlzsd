class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2]-o1[2]);
        for(int[] point : points){
            int squareValue = (point[0] * point[0]) + (point[1] * point[1]);
            pq.offer(new int[]{point[0], point[1], squareValue});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[pq.size()][2];
        int idx = 0;
        while(!pq.isEmpty()){
            int[] polledElement = pq.poll();
            result[idx] = new int[]{polledElement[0], polledElement[1]};
            idx++;
        }

        return result;
    }
}
