
class TimeMap {
    HashMap<Integer, HashMap<String, String>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(timestamp)) {
            map.put(timestamp, new HashMap<>());
        }

        map.get(timestamp).put(key, value); // 1 -> [alice : happy]

    }
    
    public String get(String key, int timestamp) {
        while(timestamp > 0) {
            if(map.containsKey(timestamp)) {
                HashMap<String, String> tempMap = map.get(timestamp);
                if(!tempMap.containsKey(key)) {
                    timestamp--;
                    continue;
                }
                return tempMap.get(key);
            }
            else timestamp--;
        }
        return "";
    }
}

/*


*/
