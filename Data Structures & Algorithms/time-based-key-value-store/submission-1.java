class ValueTimePair{
    String value;
    int timeStamp;
    public ValueTimePair(String val, int timeStamp){
        this.value = val;
        this.timeStamp = timeStamp;
    }
}
class TimeMap {
    private Map<String, List<ValueTimePair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<ValueTimePair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new ValueTimePair(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<ValueTimePair> list = map.getOrDefault(key, new ArrayList<>());
        if(list.isEmpty()){
            return "";
        }
        int l = 0;
        int r = list.size()-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            ValueTimePair vt = list.get(mid);
            if(vt.timeStamp == timestamp){
                return vt.value;
            }

            if(timestamp < vt.timeStamp){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        if(l > 0){
            ValueTimePair vt = list.get(l-1);
            return vt.value;
        }

        return "";
    }
}
