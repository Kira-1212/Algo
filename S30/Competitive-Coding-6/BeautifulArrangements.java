// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// Implemented using backtracking
// Took a boolean array to get the visited list
// We pos% i and i % pos and if the pos is greater than n we add 1 to count

class Solution {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    public void backtrack(int n, int pos, boolean[] visited) {

        if (pos > n)
            count++;

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                backtrack(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}