// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use stack to solve this problem
// we push the index of the element that we need to find the next greater on to stack
// while we go through the array we check if the element at i is greater than the element on top of the stack
// if yes we put that in the result array

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[] {};
        int[] result = new int[nums.length];
        int n = nums.length;
        Stack<Integer> s = new Stack<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int top = s.pop();
                result[top] = nums[i % n];
            }
            if (i < n) {
                s.push(i);
            }
        }
        return result;
    }
}