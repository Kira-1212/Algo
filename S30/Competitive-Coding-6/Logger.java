// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// Implemented using Hashmap
// Took a map that stores the time and the string
// We check the string in the map and get the time and if the timestamp is grater than the time we return true

class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int time = map.get(message);
            // System.out.println(time);
            if (timestamp >= time) {
                map.put(message, timestamp + 10);
                return true;
            } else
                return false;
        } else {
            map.put(message, timestamp + 10);
            return true;
        }
    }
}