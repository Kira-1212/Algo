// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach:

// This problem can be done in three ways
// Using two Hashmaps
// Using two Char Arrays
// Using One Hashmap and one Hashset

//first solution
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (smap.get(s.charAt(i)) == null) {
                smap.put(s.charAt(i), t.charAt(i));
            } else {
                if (smap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            if (tmap.get(t.charAt(i)) == null) {
                tmap.put(t.charAt(i), s.charAt(i));
            } else {
                if (tmap.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
        }
        return true;
    }
}

// Second Solution

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sArr = new char[100];
        char[] tArr = new char[100];

        for (int i = 0; i < s.length(); i++) {
            if (sArr[s.charAt(i) - ' '] == '\0') {
                sArr[s.charAt(i) - ' '] = t.charAt(i);
            } else if (sArr[s.charAt(i) - ' '] != t.charAt(i))
                return false;

            if (tArr[t.charAt(i) - ' '] == '\0') {
                tArr[t.charAt(i) - ' '] = s.charAt(i);
            } else if (tArr[t.charAt(i) - ' '] != s.charAt(i))
                return false;

        }
        return true;
    }
}

// Third Solution

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap();
        Set<Character> set = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                if (set.contains(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }

        }
        return true;
    }
}