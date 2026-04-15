class Pair{
    int val;
    int freq;
    public Pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap<>();
        for(int num : nums){
            Pair p = map.getOrDefault(num, new Pair(num, 1));
            p.freq++;
            map.put(num, p);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2)-> o1.freq - o2.freq);
        for(Integer key : map.keySet()){
            pq.offer(map.get(key));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] result = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx++] = pq.poll().val;
        }

        return result;    
    }
}
