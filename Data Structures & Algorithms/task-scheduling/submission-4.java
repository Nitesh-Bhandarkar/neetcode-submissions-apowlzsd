class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[1] - p1[1]);
        int[] freqArray = new int[26];
        for(char ch : tasks){
            freqArray[(int)ch - 'A']++;
        }

        for(int i=0; i<26; i++){
            if(freqArray[i] != 0){
                pq.offer(new int[]{i, freqArray[i]});
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int t = 0;
        while(!pq.isEmpty()){
            int[] completedTask = pq.poll();
            t++;  

            if(completedTask[1] != 1){
                q.offer(new int[]{completedTask[0], completedTask[1] - 1, t + n});
            }

            if(!q.isEmpty()){
                int[] readdTask = q.peek();
                if(pq.isEmpty()){
                    t = readdTask[2];
                }

                if(readdTask[2] <= t){
                    q.poll();
                    pq.offer(new int[]{readdTask[0], readdTask[1]});
                }
            }
        }

        return t;
        
    }
}
