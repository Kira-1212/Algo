// Time Complexity : O(N2)
// Space Complexity : O(N2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We take hashsets
// we make use of the 3 hashset arrays
// for each row, column and box we check if there is duplicate
// if yes we rturn false

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null && board.length == 0)
            return false;
        int n = 9;

        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char val = board[r][c];
                if (val == '.')
                    continue;
                if (rows[r].contains(val))
                    return false;
                rows[r].add(val);
                if (cols[c].contains(val))
                    return false;
                cols[c].add(val);

                int idx = (r / 3) * 3 + c / 3;

                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);

            }
        }
        return true;
    }
}