// Time Complexity : O(n)    
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach

//We take map and put the frequency of both tops and bottoms element
//We take target as the value that has frequency == length
//Once we get target we call the countRotations functions and return the min

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops == null || tops.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;
        for (int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
            if (map.get(tops[i]) >= tops.length) {
                target = tops[i];
                break;
            }
            if (map.get(bottoms[i]) >= tops.length) {
                target = bottoms[i];
                break;
            }

        }
        if (target == -1)
            return target;
        return countRotations(tops, bottoms, target);
    }

    private int countRotations(int[] tops, int[] bottoms, int target) {
        int topRotations = 0, bottomRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;

            }
            if (tops[i] != target) {
                topRotations++;

            }
            if (bottoms[i] != target) {
                bottomRotations++;

            }
        }
        return Math.min(topRotations, bottomRotations);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach

// We call the countRotations on tops[0]
// if result is not -1 we return the result
// else we call the function on bottoms[0]

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops == null || tops.length == 0)
            return 0;
        int result = countRotations(tops, bottoms, tops[0]);
        if (result != -1)
            return result;
        return countRotations(tops, bottoms, bottoms[0]);
    }

    private int countRotations(int[] tops, int[] bottoms, int target) {
        int topRotations = 0, bottomRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;

            }
            if (tops[i] != target) {
                topRotations++;

            }
            if (bottoms[i] != target) {
                bottomRotations++;

            }
        }
        return Math.min(topRotations, bottomRotations);
    }
}