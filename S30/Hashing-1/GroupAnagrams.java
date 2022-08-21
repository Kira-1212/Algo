
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// First Approach:

// Using one Hashmap and sorted string[i] as key and we put the values in the list

// Time Complexity : O(nklogk) 
// Space Complexity : O(n)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<Double, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            double product = primeproduct(strs[i]);
            if (!map.containsKey(product)) {
                map.put(product, new ArrayList<>());
            }
            map.get(product).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    public double primeproduct(String s) {
        double result = 1;
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101, 103 };
        for (int i = 0; i < s.length(); i++) {
            result = result * prime[s.charAt(i) - 'a'];
        }
        return result;
    }
}

// Second Approach:

// Using a primeproduct of the string to replace the computation of the sorting
// we can use one Hashmap and take primeproduct as key and we put the
// corresponding values in the list

// Time Complexity : O(nk)
// Space Complexity : O(n)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted = String.valueOf(c);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
