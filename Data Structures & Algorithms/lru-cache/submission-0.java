class LRUCache {
    int capacity;
    Map<Integer, Integer> map;
    Deque<Integer> dq;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dq = new LinkedList<>();   
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        dq.remove(key);
        dq.addFirst(key); 
        return map.get(key); 
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            dq.remove(key);
        }

        dq.addFirst(key);
        map.put(key, value);
        if(dq.size() > capacity){
            int rmKey = dq.removeLast();
            map.remove(rmKey);
        }
    }
}
