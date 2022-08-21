// Time Complexity : O(nk)    
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use two pointers to solve this
// we have a pointer for source and one for target
// we check if the char matches in source and target
// if not we increment the result

class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || source.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            map.put(source.charAt(i), i);
        }

        int i = 0;
        int pos = 0;
        int result = 1;

        while (i < target.length()) {
            if (!map.containsKey(target.charAt(i)))
                return -1;

            if (source.charAt(pos) == target.charAt(i))
                i++;
            pos++;
            if (i < target.length() && pos == source.length()) {
                pos = 0;
                result++;
            }
        }
        return result;
    }
}

// Time Complexity : O(nlogk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use a map to store the index of the characters
// we then traverse through the target string
// we get the list of indexes for the character and do the binary search get the
// k value
// using k we calculate the result

class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || source.length() == 0)
            return -1;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            if (!map.containsKey(source.charAt(i))) {
                map.put(source.charAt(i), new ArrayList<>());
            }
            map.get(source.charAt(i)).add(i);
        }

        int i = 0;
        int pos = 0;
        int result = 1;

        while (i < target.length()) {
            if (!map.containsKey(target.charAt(i)))
                return -1;

            List<Integer> li = map.get(target.charAt(i));
            int k = Collections.binarySearch(li, pos);
            if (k < 0)
                k = -k - 1;
            if (k == li.size()) {
                pos = 0;
                result++;
            } else {
                pos = li.get(k) + 1;
                i++;
            }
        }
        return result;
    }
}