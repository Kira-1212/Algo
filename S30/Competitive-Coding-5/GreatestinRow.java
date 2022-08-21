// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// We put the root in the queue
// we use level and check in that level for the greatest element add that to the result
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val > max) {
                    max = curr.val;

                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}