class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for(int[] point : points){
            int squareVal = (point[0] * point[0]) + (point[1] * point[1]);
            pq.offer(new int[]{point[0], point[1], squareVal});
            if(pq.size() > k){
                int[] p = pq.poll();
            }
        }

        int[][] result = new int[pq.size()][2];
        int idx = 0;
        while(!pq.isEmpty()){
            int[] polledVal = pq.poll();
            result[idx++] = new int[]{polledVal[0], polledVal[1]};
        }

        return result;
    }
}
