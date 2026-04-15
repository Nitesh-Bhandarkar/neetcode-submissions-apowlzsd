class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];
        for(int i=0; i<tasks.length; i++){
            freqMap[tasks[i] - 'A']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<26; i++){
            if(freqMap[i] != 0){
                pq.offer(new int[]{i, freqMap[i]});
            }  
        }

        int currCyle = 0;
        while(!pq.isEmpty()){
            int[] finishedTask = pq.poll();
            currCyle++;

            if(finishedTask[1] > 1){
                queue.offer(new int[]{finishedTask[0], finishedTask[1]-1, currCyle+n});
            }

            if(!queue.isEmpty()){
                int[] peekElement = queue.peek();
                if(pq.isEmpty()){
                    currCyle = peekElement[2];
                }
                if(peekElement[2] <= currCyle){
                    queue.poll();
                    pq.offer(new int[]{peekElement[0], peekElement[1]});
                }

            }
        }

        return currCyle;
        
    }
}
