// Time Complexity : O(n)   
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using dfs

class Solution {
    int ops;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        ops = 0;
        dfs(root);
        return ops;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int extra = root.val -1;
        extra+=dfs(root.left);
        extra+=dfs(root.right);
        ops += Math.abs(extra);
        return extra;
    }
}