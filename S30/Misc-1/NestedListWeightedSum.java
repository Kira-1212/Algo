// Time Complexity : O(depth)   
// Space Complexity : O(depth)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using dfs
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {

        return dfs(nestedList, 1);
        
    }
    int dfs(List<NestedInteger> nestedList, int depth){
        int total = 0;
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                total += nested.getInteger() * depth;
            } else {
                total += dfs(nested.getList(), depth + 1);
            }
        }
        return total;
    }
}